package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FireStationServiceTest {

    @MockBean
    FireStationRepository mockFireStationRepository;

    @MockBean
    PersonRepository mockPersonRepository;

    @MockBean
    MedicalRecordRepository mockMedicalRecordRepository;

    @Test
    void getNumberPhoneByStation() {

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