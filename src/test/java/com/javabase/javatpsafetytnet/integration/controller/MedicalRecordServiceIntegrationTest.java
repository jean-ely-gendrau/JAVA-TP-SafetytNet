package com.javabase.javatpsafetytnet.integration.controller;

import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.FireStationService;
import com.javabase.javatpsafetytnet.service.MedicalRecordService;
import com.javabase.javatpsafetytnet.service.PersonService;
import com.javabase.javatpsafetytnet.service.dto.ChildAlertDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MedicalRecordServiceIntegrationTest {

    @Autowired
    MedicalRecordService medicalRecordService;

    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    FireStationRepository fireStationRepository;

    @Autowired
    FireStationService fireStationService;

    @Test
    void getAllChildrenByAddress() {
        List<ChildAlertDTO> listChildrenDTO =  medicalRecordService.getAllChildrenByAddress("892 Downing Ct");

        assertEquals("Zemicks", listChildrenDTO.get(0).getLastName());
        assertEquals("Zach", listChildrenDTO.get(0).getFirstName());

    }
}