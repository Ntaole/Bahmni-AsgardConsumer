package com.asgard.consumer.mrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.mrs.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query("SELECT rp FROM Order rp WHERE rp.patientId = :value")
    List<Order> findByid(@Param("value") Integer value);

}
