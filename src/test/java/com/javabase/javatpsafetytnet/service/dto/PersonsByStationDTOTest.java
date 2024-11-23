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
class PersonsByStationDTOTest {

    @Mock
    Comparable<String> firestation, address;

    @Mock
    List<PersonContactMedicalHistoryDTO> personContactMedicalHistoryDTOList;

    @InjectMocks
    PersonsByStationDTO mockPersonsByStationDTO;


    @BeforeEach
    void setUp(){
        mockPersonsByStationDTO.setFirestation("1");
        mockPersonsByStationDTO.setAddress("1509 Culver St");
        mockPersonsByStationDTO.setPersonFireAlertList(personContactMedicalHistoryDTOList);

    }

    @Test
    void getFirestation() {
        assertEquals("1", mockPersonsByStationDTO.getFirestation());
    }

    @Test
    void getPersonFireAlertList() {
        assertEquals(personContactMedicalHistoryDTOList, mockPersonsByStationDTO.getPersonFireAlertList());
    }

    @Test
    void getAddress() {
        assertEquals("1509 Culver St", mockPersonsByStationDTO.getAddress());
    }

    @Test
    void setFirestation() {
        assertEquals("1", mockPersonsByStationDTO.getFirestation());
    }

    @Test
    void setPersonFireAlertList() {
        assertEquals(personContactMedicalHistoryDTOList, mockPersonsByStationDTO.getPersonFireAlertList());
    }

    @Test
    void setAddress() {
        assertEquals("1509 Culver St", mockPersonsByStationDTO.getAddress());
    }
}