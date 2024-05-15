package com.asgard.consumer.mrs.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.asgard.consumer.mrs.model.Encounter;
import com.asgard.consumer.mrs.repository.EncounterRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EncounterService {
    public final EncounterRepo encounterRepo;
        public List<Encounter> Findbyuuid(String string) {
        return encounterRepo.findByuuid(string);
    }


}
