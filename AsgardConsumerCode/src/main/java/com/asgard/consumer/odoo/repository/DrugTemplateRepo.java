package com.asgard.consumer.odoo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.odoo.model.DrugTemplate;
import com.asgard.consumer.odoo.model.ResPartner;

@Repository
public interface DrugTemplateRepo extends JpaRepository<DrugTemplate,Integer>{


    @Query("SELECT rp FROM DrugTemplate rp WHERE rp.uuid = :value")
    List<DrugTemplate> findByuuid(@Param("value") String value);

    
}
