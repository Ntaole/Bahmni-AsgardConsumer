package com.asgard.consumer;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

import com.asgard.consumer.mrs.model.Drug;
import com.asgard.consumer.mrs.model.PersonName;
import com.asgard.consumer.mrs.service.DrugService;
import com.asgard.consumer.mrs.service.IdentifierService;
import com.asgard.consumer.mrs.service.PersonService;
import com.asgard.consumer.mrs.service.realPersonService;
import com.asgard.consumer.odoo.model.DrugProduct;
import com.asgard.consumer.odoo.model.DrugTemplate;
import com.asgard.consumer.odoo.model.ResPartner;
import com.asgard.consumer.odoo.service.DrugProductService;
import com.asgard.consumer.odoo.service.DrugTemplateService;
import com.asgard.consumer.odoo.service.OdooService;

import lombok.AllArgsConstructor;

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
List<User> orderslist = new ArrayList<>();

	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.event_records", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> orders(User event) {

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
	else if("encounter".equals(event.getCategory())){

	}
	return orderslist;

}


	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
