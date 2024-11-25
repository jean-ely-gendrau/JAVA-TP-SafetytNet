package com.javabase.javatpsafetytnet.integration.controller;

import com.javabase.javatpsafetytnet.controller.PersonController;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.MedicalRecordService;
import com.javabase.javatpsafetytnet.service.PersonService;
import com.javabase.javatpsafetytnet.service.dto.PersonMedicalHistoryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class PersonControllerIntegrationTest {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Autowired
    PersonController personController;

    @Autowired
    PersonService personService;

    @Autowired
    MedicalRecordService medicalRecordService;


    @BeforeEach
    void setUp() throws Exception {

    }

    @Test
    void getCommunityEmail() throws Exception {

        List<String> personList = personService.findCommunityEmail("test");

        List<String> personListExcepted = new ArrayList<>(List.of(
                "test@test.com"
        ));

        assertEquals(personListExcepted, personList);
    }

    @Test
    void getPersonInfo() {
        List<PersonMedicalHistoryDTO> personList = personService.findPersonInfo("Boyd", "John");

        assertEquals("Boyd", personList.get(0).getLastName());
    }
}
