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
class MedicalHistoryDTOTest {

    @Mock
    List<String> medications, allergies;

    @InjectMocks
    MedicalHistoryDTO mockMedicalHistoryDTO;

    @BeforeEach
    void setUp(){
        medications.add("paracetamol:1000mg");
        allergies.add("peanuts");

        mockMedicalHistoryDTO.setMedications(medications);
        mockMedicalHistoryDTO.setAllergies(allergies);
    }

    @Test
    void getMedications() {
        assertEquals(medications, mockMedicalHistoryDTO.getMedications());
    }

    @Test
    void getAllergies() {
        assertEquals(allergies, mockMedicalHistoryDTO.getAllergies());
    }

    @Test
    void setMedications() {
        assertEquals(medications, mockMedicalHistoryDTO.getMedications());
    }

    @Test
    void setAllergies() {
        assertEquals(allergies, mockMedicalHistoryDTO.getAllergies());
    }
}