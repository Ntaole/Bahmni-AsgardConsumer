package com.asgard.consumer.mrs.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.mrs.model.PersonName;
import com.asgard.consumer.odoo.model.ResPartner;

@Repository
public interface MrsRepo extends JpaRepository<PersonName,Integer> {

    @Query("SELECT rp FROM PersonName rp WHERE rp.personId = :value")
    List<PersonName> findByid(@Param("value") Integer value);
}
