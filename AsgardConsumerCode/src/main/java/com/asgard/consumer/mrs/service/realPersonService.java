package com.asgard.consumer.mrs.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.asgard.consumer.mrs.model.Person;
import com.asgard.consumer.mrs.model.PersonName;
import com.asgard.consumer.mrs.repository.MrsRepo;
import com.asgard.consumer.mrs.repository.PersonRepo;

@Service
public class realPersonService {

    public final PersonRepo mrsRepo;

    public realPersonService(PersonRepo mrsRepo) {
        this.mrsRepo = mrsRepo;
    }

       public List<Person> selectall() {
        return mrsRepo.findAll();
    }

    public List<Person> idsearch(String uuid){
        return mrsRepo.findByuuid(uuid);
    }


}
