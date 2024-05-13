package com.asgard.consumer.mrs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.mrs.model.Drug;

@Repository
public interface DrugRepo extends JpaRepository<Drug,Integer>{


    @Query("SELECT rp FROM Drug rp WHERE rp.uuid = :value")
    List<Drug> findByuuid(@Param("value") String value);

}
