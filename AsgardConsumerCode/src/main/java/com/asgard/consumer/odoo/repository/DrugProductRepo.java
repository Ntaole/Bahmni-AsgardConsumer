package com.asgard.consumer.odoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.odoo.model.DrugProduct;

@Repository
public interface DrugProductRepo extends JpaRepository<DrugProduct,Integer>{

    

}
