package com.asgard.consumer.mrs.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.asgard.consumer.mrs.model.PatientIdentifier;
import com.asgard.consumer.mrs.model.PersonName;
import com.asgard.consumer.mrs.repository.IdentifierRepo;
import com.asgard.consumer.mrs.repository.MrsRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class IdentifierService {

    public final IdentifierRepo identifierRepo;

       public List<PatientIdentifier> selectall() {
        return identifierRepo.findAll();
    }

    public List<PatientIdentifier> findIdentifiers(Integer integer) {
        return identifierRepo.findByid(integer);
    }

}
