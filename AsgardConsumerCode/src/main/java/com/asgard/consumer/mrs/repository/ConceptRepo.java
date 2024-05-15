package com.asgard.consumer.mrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.mrs.model.Concept;
import com.asgard.consumer.mrs.model.Order;

@Repository
public interface ConceptRepo extends JpaRepository<Concept,Integer> {

    @Query("SELECT rp FROM Concept rp WHERE rp.conceptId = :value")
    List<Concept> findByid(@Param("value") Integer value);

}
