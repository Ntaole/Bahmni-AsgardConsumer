package com.asgard.consumer.odoo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asgard.consumer.odoo.model.DrugProduct;
import com.asgard.consumer.odoo.model.ResPartner;
import com.asgard.consumer.odoo.model.SaleOrder;
import com.asgard.consumer.odoo.repository.SaleOrderRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class SaleOrderService {
    public final SaleOrderRepo saleOrderRepo;

        public List<SaleOrder> findBypid(Integer integer) {
        return saleOrderRepo.findBypatientid(integer);
    } 

        public SaleOrder insertInto(SaleOrder sale) {
        return saleOrderRepo.save(sale);
    } 


}
