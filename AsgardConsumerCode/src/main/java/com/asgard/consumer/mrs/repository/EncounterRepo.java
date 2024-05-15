package com.asgard.consumer.mrs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.mrs.model.Encounter;
@Repository
public interface EncounterRepo extends JpaRepository<Encounter,Integer> {

    
    @Query("SELECT rp FROM Encounter rp WHERE rp.uuid = :value")
    List<Encounter> findByuuid(@Param("value") String value);


}
