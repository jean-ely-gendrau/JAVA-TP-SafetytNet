package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.ChildAlertDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    /**
     * Wired Repositories
     */
    private final PersonRepository personRepository;

    /**
     * PersonService
     * Wire Repository
     * @param personRepository
     */
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * findCommunityEmail
     *
     * @param city
     * @return
     */
    public List<String> findCommunityEmail(String city){
       return personRepository
               .findByCity(city)
               .stream()
               .map(person -> person.getEmail())
               .distinct()
               .collect(Collectors.toList());
    }

}
