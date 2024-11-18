package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {


    private final PersonService alertService;

    public PersonController(PersonService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/communityEmail")
    public List<String> getCommunityEmail(@RequestParam(name ="city") String city){
        return alertService.findCommunityEmail(city);
    }

}
