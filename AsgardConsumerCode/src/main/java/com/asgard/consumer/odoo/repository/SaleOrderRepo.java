package com.asgard.consumer.odoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.odoo.model.SaleOrder;
@Repository
public interface SaleOrderRepo extends JpaRepository<SaleOrder, Integer> {

    @Query("SELECT rp FROM SaleOrder rp WHERE rp.partnerId = :value")
    List<SaleOrder> findBypatientid(@Param("value") Integer value);

}
