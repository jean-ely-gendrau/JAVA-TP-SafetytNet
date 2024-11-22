package com.javabase.javatpsafetytnet.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonMedicalHistoryDTOTest {

    @Mock
    Comparable<String> lastName, address, email, age;

    @Mock
    MedicalHistoryDTO medicalHistoryDTO;

    @InjectMocks
    PersonMedicalHistoryDTO mockPersonMedicalHistoryDTO;

    @BeforeEach
    void setUp(){
        mockPersonMedicalHistoryDTO.setLastName("LastName");
        mockPersonMedicalHistoryDTO.setAddress("1509 Culver St");
        mockPersonMedicalHistoryDTO.setEmail("lastname@email.com");
        mockPersonMedicalHistoryDTO.setAge("18");
        mockPersonMedicalHistoryDTO.setMedicalHistoryList(medicalHistoryDTO);

    }

    @Test
    void getLastName() {
        assertEquals("LastName", mockPersonMedicalHistoryDTO.getLastName());
    }

    @Test
    void getAddress() {
        assertEquals("1509 Culver St", mockPersonMedicalHistoryDTO.getAddress());
    }

    @Test
    void getEmail() {
        assertEquals("lastname@email.com", mockPersonMedicalHistoryDTO.getEmail());
    }

    @Test
    void getAge() {
        assertEquals("18", mockPersonMedicalHistoryDTO.getAge());
    }

    @Test
    void getMedicalHistoryList() {
        assertEquals(medicalHistoryDTO, mockPersonMedicalHistoryDTO.getMedicalHistoryList());
    }

    @Test
    void setLastName() {
        assertEquals("LastName", mockPersonMedicalHistoryDTO.getLastName());
    }

    @Test
    void setAddress() {
        assertEquals("1509 Culver St", mockPersonMedicalHistoryDTO.getAddress());
    }

    @Test
    void setEmail() {
        assertEquals("lastname@email.com", mockPersonMedicalHistoryDTO.getEmail());
    }

    @Test
    void setAge() {
        assertEquals("18", mockPersonMedicalHistoryDTO.getAge());
    }

    @Test
    void setMedicalHistoryList() {
        assertEquals(medicalHistoryDTO, mockPersonMedicalHistoryDTO.getMedicalHistoryList());
    }
}