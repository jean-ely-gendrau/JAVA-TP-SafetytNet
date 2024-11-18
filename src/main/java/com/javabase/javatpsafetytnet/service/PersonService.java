package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository alertDAO;

    public PersonService(PersonRepository alertDAO) {
        this.alertDAO = alertDAO;
    }

    public List<String> findCommunityEmail(String city){
       return alertDAO.findByCity(city);
    }


}
