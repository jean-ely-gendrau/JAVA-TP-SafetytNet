package com.javabase.javatpsafetytnet.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.DataRepository;
import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FireStationServiceTest {

    @Mock
    FireStationRepository mockFireStationRepository;

    @Mock
    PersonRepository mockPersonRepository;

    @Mock
    MedicalRecordRepository mockMedicalRecordRepository;

    @InjectMocks
    FireStationService fireStationService;

    private List<FireStation> fireStationList;
    private List<MedicalRecord> medicalRecordList;
    private List<Person> personList;

    @BeforeEach
    void setUp() throws JsonProcessingException {

        MedicalRecord medicalRecord = new MedicalRecord();

        this.medicalRecordList = new ArrayList<>();

        this.medicalRecordList.add(medicalRecord);

        this.medicalRecordList.add(medicalRecord);

        FireStation fireStationA = new FireStation(
                "address A",
                "1"
        );

        FireStation fireStationB = new FireStation(
                "address B",
                "1"
        );

        FireStation fireStationC = new FireStation(
                "address C",
                "2"
        );

        this.fireStationList = new ArrayList<>();

        this.fireStationList.add(fireStationA);
        this.fireStationList.add(fireStationB);
        this.fireStationList.add(fireStationC);

        Person personA = new Person(
                "fistNameA",
                "lastNameA",
                "address A",
                "cityA",
                "83000",
                "111-111-111",
                "email-a@test.com"
        );

        Person personB = new Person(
                "fistNameB",
                "lastNameB",
                "address B",
                "cityB",
                "83000",
                "222-222-222",
                "email-b@test.com"
        );

        Person personC = new Person(
                "fistNameC",
                "lastNameC",
                "address C",
                "cityC",
                "83000",
                "333-333-333",
                "email-c@gtest.com"
        );

        this.personList = new ArrayList<>();

        this.personList.add(personA);
        this.personList.add(personB);
        this.personList.add(personC);

    }

    @Test
    void getNumberPhoneByStation() {

        String stationNumber = "2";

        when(
                mockFireStationRepository.findByStation(anyString())
        ).thenReturn(
                List.of(
                        fireStationList.get(0).getAddress(),
                        fireStationList.get(1).getAddress()
                )
        );

      when(
              mockPersonRepository.findAll()
      ).thenReturn(personList);


        List<String> returned = fireStationService.getNumberPhoneByStation(stationNumber);

        assertEquals(2, returned.size());

        assertEquals(
                Arrays.asList("111-111-111", "222-222-222"),
                returned
                );

    }

    @Test
    void getAllPersonsByAddress() {
    }

    @Test
    void getAllPersonsByStations() {
    }

    @Test
    void getAllPersonsByStation() {
    }
}