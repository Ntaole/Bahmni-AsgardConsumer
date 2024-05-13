package com.asgard.consumer.mrs.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.asgard.consumer.mrs.model.Drug;
import com.asgard.consumer.mrs.repository.DrugRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DrugService {

    public final DrugRepo drugRepo;

        public List<Drug> Findbyuuid(String string) {
        return drugRepo.findByuuid(string);
    }

}
