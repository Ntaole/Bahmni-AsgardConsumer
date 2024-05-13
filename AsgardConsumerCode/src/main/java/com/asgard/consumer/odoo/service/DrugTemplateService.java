package com.asgard.consumer.odoo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.asgard.consumer.odoo.model.DrugTemplate;
import com.asgard.consumer.odoo.repository.DrugTemplateRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DrugTemplateService {

    public final DrugTemplateRepo drugTemplateRepo;

       public List<DrugTemplate> findByuuid(String string) {
        return drugTemplateRepo.findByuuid(string);
    } 

    public DrugTemplate insertInto(DrugTemplate drugTemplate) {
        return drugTemplateRepo.save(drugTemplate);
    } 

}
