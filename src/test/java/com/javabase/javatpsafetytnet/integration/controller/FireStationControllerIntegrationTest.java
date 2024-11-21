package com.javabase.javatpsafetytnet.integration.controller;

import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.FireStationService;
import com.javabase.javatpsafetytnet.service.MedicalRecordService;
import com.javabase.javatpsafetytnet.service.PersonService;
import com.javabase.javatpsafetytnet.service.dto.PersonsByStationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FireStationControllerIntegrationTest {

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
    void phoneAlert() {
      List<String> listPoneNumber = fireStationService.getNumberPhoneByStation("1");
      List<String> phoneDataExcepted =  new ArrayList<>(List.of(
              "841-874-6512",
              "841-874-8547",
              "841-874-7462",
              "841-874-7784"
      ));


      assertEquals(4, listPoneNumber.size());
      assertEquals(phoneDataExcepted, listPoneNumber);
    }

    @Test
    void fireAlert() {
        List<String> listFirestationNumber = new ArrayList<>();
        listFirestationNumber.add(0,"1");

        List<PersonsByStationDTO> personsByStationDTOList = fireStationService.getAllPersonsByStations(listFirestationNumber);
    }

    @Test
    void floodStation() {
    }

    @Test
    void fireStation() {
    }
}