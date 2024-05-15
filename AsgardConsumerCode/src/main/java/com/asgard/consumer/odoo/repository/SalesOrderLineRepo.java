package com.asgard.consumer.odoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.odoo.model.SaleOrderLine;

@Repository
public interface SalesOrderLineRepo extends JpaRepository <SaleOrderLine,Integer>{



}
