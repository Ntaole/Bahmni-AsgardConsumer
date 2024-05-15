package com.asgard.consumer.mrs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asgard.consumer.mrs.model.Concept;
import com.asgard.consumer.mrs.repository.ConceptRepo;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ConceptService {

public final ConceptRepo conceptRepo;

        public List<Concept> Findbyid(Integer integer) {
        return conceptRepo.findByid(integer);
    }
    
}
