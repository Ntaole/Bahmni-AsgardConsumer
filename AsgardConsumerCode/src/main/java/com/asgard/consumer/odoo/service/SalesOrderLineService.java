package com.asgard.consumer.odoo.service;

import org.springframework.stereotype.Service;

import com.asgard.consumer.odoo.model.ResPartner;
import com.asgard.consumer.odoo.model.SaleOrderLine;
import com.asgard.consumer.odoo.repository.SalesOrderLineRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class SalesOrderLineService {

    public final SalesOrderLineRepo salesOrderLineRepo;

        public SaleOrderLine InsertInto(SaleOrderLine saleOrderLine) {
        return salesOrderLineRepo.save(saleOrderLine);
    } 



}
