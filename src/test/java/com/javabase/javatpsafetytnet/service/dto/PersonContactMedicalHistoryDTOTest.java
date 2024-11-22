package com.javabase.javatpsafetytnet.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonContactMedicalHistoryDTOTest {

    @Mock
    Comparable<String> lastName, phone, age;

    @Mock
    List<MedicalHistoryDTO> medicalHistoryDTOList;

    @InjectMocks
    PersonContactMedicalHistoryDTO mockPersonContactMedicalHistoryDTO;

    @BeforeEach
    void setUp(){
        mockPersonContactMedicalHistoryDTO.setLastName("LastName");
        mockPersonContactMedicalHistoryDTO.setPhone("111-111-111");
        mockPersonContactMedicalHistoryDTO.setAge("20");

        mockPersonContactMedicalHistoryDTO.setMedicalHistoryList(medicalHistoryDTOList);
    }

    @Test
    void getLastName() {
        assertEquals("LastName", mockPersonContactMedicalHistoryDTO.getLastName());
    }

    @Test
    void getPhone() {
        assertEquals("111-111-111", mockPersonContactMedicalHistoryDTO.getPhone());
    }

    @Test
    void getAge() {
        assertEquals("20", mockPersonContactMedicalHistoryDTO.getAge());
    }

    @Test
    void getMedicalHistoryList() {
        assertEquals(medicalHistoryDTOList, mockPersonContactMedicalHistoryDTO.getMedicalHistoryList());
    }

    @Test
    void setLastName() {
        assertEquals("LastName", mockPersonContactMedicalHistoryDTO.getLastName());
    }

    @Test
    void setPhone() {
        assertEquals("111-111-111", mockPersonContactMedicalHistoryDTO.getPhone());
    }

    @Test
    void setAge() {
        assertEquals("20", mockPersonContactMedicalHistoryDTO.getAge());
    }

    @Test
    void setMedicalHistoryList() {
        assertEquals(medicalHistoryDTOList, mockPersonContactMedicalHistoryDTO.getMedicalHistoryList());
    }
}