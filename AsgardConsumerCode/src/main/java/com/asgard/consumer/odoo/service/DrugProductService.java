package com.asgard.consumer.odoo.service;

import org.springframework.stereotype.Service;

import com.asgard.consumer.odoo.model.DrugProduct;
import com.asgard.consumer.odoo.model.DrugTemplate;
import com.asgard.consumer.odoo.repository.DrugProductRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DrugProductService {

    public final DrugProductRepo drugProductRepo;

        public DrugProduct insertInto(DrugProduct drugProduct) {
        return drugProductRepo.save(drugProduct);
    } 

}
