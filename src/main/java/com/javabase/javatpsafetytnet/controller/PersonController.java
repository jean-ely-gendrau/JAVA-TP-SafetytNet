package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.PersonService;
import com.javabase.javatpsafetytnet.service.dto.ChildAlertDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {


    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/communityEmail")
    public List<String> getCommunityEmail(@RequestParam(name ="city") String city){
        return personService.findCommunityEmail(city);
    }

    @GetMapping("/personInfo")
    public List
}
