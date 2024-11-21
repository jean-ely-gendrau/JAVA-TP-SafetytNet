package com.javabase.javatpsafetytnet.integration.controller;

import com.javabase.javatpsafetytnet.controller.PersonController;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.MedicalRecordService;
import com.javabase.javatpsafetytnet.service.PersonService;
import com.javabase.javatpsafetytnet.service.dto.PersonMedicalHistoryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
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

    @Test
    void getCommunityEmail() throws Exception {

        List<String> personList = personService.findCommunityEmail("Culver");

        List<String> personListExcepted = new ArrayList<>(List.of(
                "jaboyd@email.com",
                "drk@email.com",
                "tenz@email.com",
                "tcoop@ymail.com",
                "lily@email.com",
                "soph@email.com",
                "ward@email.com",
                "zarc@email.com",
                "reg@email.com",
                "jpeter@email.com",
                "aly@imail.com",
                "bstel@email.com",
                "ssanw@email.com",
                "clivfd@ymail.com",
                "gramps@email.com"
        ));

        assertEquals(personListExcepted, personList);
    }

    @Test
    void getPersonInfo() {
        List<PersonMedicalHistoryDTO> personList = personService.findPersonInfo("Boyd", "John");

        assertEquals("Boyd", personList.get(0).getLastName());
    }
}
