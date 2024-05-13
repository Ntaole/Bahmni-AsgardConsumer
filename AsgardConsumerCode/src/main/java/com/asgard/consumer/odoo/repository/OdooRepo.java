package com.asgard.consumer.odoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.asgard.consumer.odoo.model.ResPartner;


@Repository
public interface OdooRepo extends JpaRepository<ResPartner,Integer> {

    @Query("SELECT rp FROM ResPartner rp WHERE rp.uuid = :value")
    List<ResPartner> findByuuid(@Param("value") String value);

    
}
