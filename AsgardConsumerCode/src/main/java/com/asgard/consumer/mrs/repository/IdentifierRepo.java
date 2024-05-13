package com.asgard.consumer.mrs.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.mrs.model.PatientIdentifier;

@Repository
public interface IdentifierRepo extends JpaRepository<PatientIdentifier, Integer> {

    @Query("SELECT rp FROM PatientIdentifier rp WHERE rp.patientId = :value")
    List<PatientIdentifier> findByid(@Param("value") Integer value);

}
