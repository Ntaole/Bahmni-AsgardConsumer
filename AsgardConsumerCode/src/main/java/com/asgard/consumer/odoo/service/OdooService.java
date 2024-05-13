package com.asgard.consumer.odoo.service;


import org.springframework.stereotype.Service;

import com.asgard.consumer.odoo.model.ResPartner;
import com.asgard.consumer.odoo.repository.OdooRepo;
import java.util.List;


@Service
public class OdooService {
 public OdooService(OdooRepo odoor) {
        this.odooRepo = odoor;
    }

public final OdooRepo odooRepo;

   public List<ResPartner> selectall() {
        return odooRepo.findAll();
    }
    public ResPartner InsertInto(ResPartner resPartner) {
        return odooRepo.save(resPartner);
    } 

    public List<ResPartner> findByuuid(String string) {
        return odooRepo.findByuuid(string);
    } 

}
