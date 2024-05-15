package com.asgard.consumer;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.asgard.consumer.mrs.model.Concept;
import com.asgard.consumer.mrs.model.Drug;
import com.asgard.consumer.mrs.model.Encounter;
import com.asgard.consumer.mrs.model.Order;
import com.asgard.consumer.mrs.model.Person;
import com.asgard.consumer.mrs.model.PersonName;
import com.asgard.consumer.mrs.service.ConceptService;
import com.asgard.consumer.mrs.service.DrugService;
import com.asgard.consumer.mrs.service.EncounterService;
import com.asgard.consumer.mrs.service.IdentifierService;
import com.asgard.consumer.mrs.service.OrderService;
import com.asgard.consumer.mrs.service.PersonService;
import com.asgard.consumer.mrs.service.realPersonService;
import com.asgard.consumer.odoo.model.DrugProduct;
import com.asgard.consumer.odoo.model.DrugTemplate;
import com.asgard.consumer.odoo.model.ResPartner;
import com.asgard.consumer.odoo.model.SaleOrder;
import com.asgard.consumer.odoo.model.SaleOrderLine;
import com.asgard.consumer.odoo.service.DrugProductService;
import com.asgard.consumer.odoo.service.DrugTemplateService;
import com.asgard.consumer.odoo.service.OdooService;
import com.asgard.consumer.odoo.service.SaleOrderService;
import com.asgard.consumer.odoo.service.SalesOrderLineService;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode.Exclude;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
@AllArgsConstructor
public class ConsumerApplication {


public final OdooService odooService;
public final PersonService personService;
public final realPersonService realpersonService;
public final IdentifierService identifierService;
public final DrugService drugService;
public final DrugTemplateService drugTemplateService;
public final DrugProductService drugProductService;
public final EncounterService encounterService;
public final SaleOrderService saleOrderService;
public final OrderService orderService;
public final SalesOrderLineService salesOrderLineService;
public final ConceptService conceptService;
//private int counter = 0;



List<User> orderslist = new ArrayList<>();

	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.event_records", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> orders(User event) {
		System.out.println("i am hererrerere");
		System.out.println(event);


	//If event is drug 
	if("drug".equals(event.getCategory())){

		String uuString = event.getObject().substring(40,40+36);
		List<Drug> drug = drugService.Findbyuuid(uuString);
		List<DrugTemplate> checkdrug = drugTemplateService.findByuuid(uuString);


		if(checkdrug.isEmpty()){

			Tempdrug tempdrug = new Tempdrug(drug.get(0).getName(), drug.get(0).getStrength(), uuString);
			DrugTemplate toinsert = new DrugTemplate(tempdrug);
			DrugTemplate inserted = drugTemplateService.insertInto(toinsert);
			DrugProduct newdrug = new DrugProduct(uuString, inserted.getId());
			drugProductService.insertInto(newdrug);
		}else{
			System.out.println("not empty");


			Tempdrug tempdrug = new Tempdrug(drug.get(0).getName(), drug.get(0).getStrength(), uuString);
			DrugTemplate toinsert = new DrugTemplate(tempdrug);
			toinsert.setId(checkdrug.get(0).getId());
			drugTemplateService.insertInto(toinsert);
		}


	}
	//if event is patient
	else if("patient".equals(event.getCategory())){
		Integer tempid = null;
		String uuString = event.getObject().substring(28,28+36);
		List<ResPartner> checklist = odooService.findByuuid(uuString);
		System.out.println(uuString);
		if(!checklist.isEmpty()){
			tempid = checklist.get(0).getId();
		}
		Integer eventPersonId = realpersonService.idsearch(uuString).get(0).getPersonId();
		PersonName eventPersonnameE = personService.findbyid(eventPersonId).get(0);
		String name = eventPersonnameE.getGivenName()+" "+eventPersonnameE.getMiddleName()+" "+eventPersonnameE.getFamilyName();
		String identifier = identifierService.findIdentifiers(eventPersonId).get(1).getIdentifier();
		String displayname = name +"["+identifier+"]";
		Respartner respartner=  new Respartner(tempid,name,displayname,identifier,uuString);
		ResPartner resRartner = new ResPartner(respartner);

		//Insert into res.partner table
		if(!"N".equals(identifier.substring(0,1))){
			odooService.InsertInto(resRartner);
		}

	}

	//if event is encounter
	else if("Encounter".equals(event.getCategory())){
		//get encouter uuid
		String uuString = event.getObject().substring(28+19,19+28+36);
		System.out.println(uuString);
		//get encouter infromation in openmrs
		Encounter encountered = encounterService.Findbyuuid(uuString).get(0);
		System.out.println(encountered);
		//identify patient as customer in odoo
		Person patient = realpersonService.findbyid(encountered.getPatientId()).get(0);
		List<ResPartner> checklist = odooService.findByuuid(patient.getUuid());
		System.out.println("could not "+checklist.size());
		//return error if patient not found...poor exeption handling needs update in future versions
		if(checklist.isEmpty()){
			System.out.println("could not find encountered patient");
		}
		else{
			System.out.println("could not "+checklist.size());

			ResPartner customer  = checklist.get(0);
			System.out.println("herrrr"+customer);

			List<SaleOrder> pendingorders = saleOrderService.findBypid(customer.getId());
			if(pendingorders.isEmpty()){

				//Making a new order name system, original order system is SOXX to be reworked later
					String Ordername = "LM";
					Integer customerid = customer.getId();
	
					//provider names and id are nullable but needs to be reworked in later versions
					String providername = "Asgardian";
					Integer providerid= null;
					String provieruuid= null;
	
					
					String caresetting = "Hospital";
	
	
					//minimal constructor for inserts
					SaleOrder neworder = new SaleOrder(
						customerid,
						Ordername,
						providerid,
						providername,
						caresetting,
						null
					);

					//create new order if no order existed before with constructed information
					neworder = saleOrderService.insertInto(neworder);
					List<Order> orderList = orderService.findorders(patient.getPersonId());
					if(orderList.isEmpty()){
//						System.out.println("No orders detected");
	
					}else{
//						System.out.println("orrrrrderrrr"+orderList.size());
						
						for(int i = 0 ;i <orderList.size();i++){
	
							Integer saleorderid = neworder.getId();
							List<Concept> concept = conceptService.Findbyid(orderList.get(i).getConceptId());
							String concepString = concept.get(0).getUuid();
							DrugProduct tempproduct = drugProductService.findByuuid(concepString).get(0);
							Integer productid = tempproduct.getId();
							//Integer orderid = neworder.getId();
							DrugTemplate tempdrug = drugTemplateService.findByid(productid).get(0);
							String name  =tempdrug.getName();
							SaleOrderLine newsalesorderline = new SaleOrderLine(
								customerid,
								saleorderid,
								productid,
								name
							);
							salesOrderLineService.InsertInto(newsalesorderline);
		
						}
					}
	
	
				}
				else{
					List<Order> orderList = orderService.findorders(patient.getPersonId());
					Integer customerid = customer.getId();

					if(orderList.isEmpty()){
						System.out.println("No orders detected");
	
					}else{
						System.out.println("not found"+orderList.size());

						SaleOrder neworder =pendingorders.get(0);
	
	
						for(int i = 0 ;i <orderList.size();i++){
	
							Integer saleorderid = neworder.getId();
							List<Concept> concept = conceptService.Findbyid(orderList.get(i).getConceptId());
							String concepString = concept.get(0).getUuid();
							DrugProduct tempproduct = drugProductService.findByuuid(concepString).get(0);
							Integer productid = tempproduct.getId();
							//Integer orderid = neworder.getId();
							DrugTemplate tempdrug = drugTemplateService.findByid(productid).get(0);
							String name  =tempdrug.getName();
							SaleOrderLine newsalesorderline = new SaleOrderLine(
								customerid,
								saleorderid,
								productid,
								name
							);
							salesOrderLineService.InsertInto(newsalesorderline);
		
						}
					}


	
				}


		}
	}
	return orderslist;

}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
