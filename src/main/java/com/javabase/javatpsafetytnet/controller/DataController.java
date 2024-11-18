package com.javabase.javatpsafetytnet.controller;

//import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.service.DataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/data")
public class DataController {

    // Declare Service
    private final DataService dataService;

    // Wire Service
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    // Get List Personnes
    @GetMapping
    public List<Person> getPersonnesModel(Data data){
        return dataService.getData().getPersons();
    }
}
