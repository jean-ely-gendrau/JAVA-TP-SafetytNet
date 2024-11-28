package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.service.PersonService;
import com.javabase.javatpsafetytnet.service.dto.PersonMedicalHistoryDTO;
import org.springframework.web.bind.annotation.*;

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

    /**
     * addNewPerson
     *
     * @param person
     * @return Person
     * @throws Exception
     */
    @PostMapping("/addPerson")
    public Person addNewPerson(
            @RequestBody Person person
    ) throws Exception {

        return personService.addPerson(person);

    }

    @PutMapping("/updatePerson")
    public Person updatePerson(
            @RequestBody Person person
    ) throws Exception {

        return  personService.updatePerson(person);

    }

    /**
     * deletePerson
     *
     * @param lastName
     * @param firstName
     * @return Person
     * @throws Exception
     */
    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestParam String lastName,
                               @RequestParam String firstName
    ) throws Exception {

        return personService.deletePerson(lastName, firstName);

    }
}
