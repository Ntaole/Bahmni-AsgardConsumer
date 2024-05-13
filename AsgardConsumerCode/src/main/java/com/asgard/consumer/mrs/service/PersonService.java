package com.asgard.consumer.mrs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asgard.consumer.mrs.model.PersonName;
import com.asgard.consumer.mrs.repository.MrsRepo;


@Service
public class PersonService {

    public final MrsRepo mrsRepo;

    public PersonService(MrsRepo mrsRepo) {
        this.mrsRepo = mrsRepo;
    }

       public List<PersonName> findbyid(Integer integer) {
        return mrsRepo.findByid(integer);
    }


}
