package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.PersonService;
import com.javabase.javatpsafetytnet.service.dto.PersonMedicalHistoryDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    /**
     * Wired Services
     */
    private final PersonService personService;

    /**
     * Constructor
     * Wire services
     *
     * @param personService
     */
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * getCommunityEmail
     *
     * @param city
     * @return List String
     */
    @GetMapping("/communityEmail")
    public List<String> getCommunityEmail(@RequestParam(name = "city") String city) {
        return personService.findCommunityEmail(city);
    }

    /**
     * getPersonInfo
     *
     * @param lastName
     * @param firstName
     * @return List PersonMedicalHistoryDTO
     */

    @GetMapping("/personInfo")
    public List<PersonMedicalHistoryDTO> getPersonInfo(
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "firstName") String firstName
    ) {
        return personService.findPersonInfo(lastName, firstName);
    }
}
