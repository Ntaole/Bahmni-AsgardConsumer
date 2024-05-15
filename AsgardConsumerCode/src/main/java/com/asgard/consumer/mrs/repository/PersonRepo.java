package com.asgard.consumer.mrs.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asgard.consumer.mrs.model.Person;
import com.asgard.consumer.mrs.model.PersonName;

public interface PersonRepo  extends JpaRepository<Person,Integer>{

    @Query("SELECT rp FROM Person rp WHERE rp.uuid = :value")
    List<Person> findByuuid(@Param("value") String value);

    @Query("SELECT rp FROM Person rp WHERE rp.personId = :value")
    List<Person> findByid(@Param("value") Integer value);
}
