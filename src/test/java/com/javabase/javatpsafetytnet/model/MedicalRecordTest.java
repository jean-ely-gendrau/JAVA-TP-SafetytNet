package com.javabase.javatpsafetytnet.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MedicalRecordTest {

    @Mock
    Comparable<String> mockFirstName, mockLastName, mockBirthdate;

    @Mock
    List<String> mockMedicationsList, mockAllergiesList;

    @InjectMocks
    MedicalRecord mockMedicalRecord;

    @BeforeEach
    void setUp(){
        mockMedicalRecord.setLastName("Dupon");
        mockMedicalRecord.setFirstName("Jean");
        mockMedicalRecord.setBirthdate("12/31/2000");

        mockMedicationsList.add("tramadol:2000MG");
        mockMedicalRecord.setMedications(mockMedicationsList);

        mockAllergiesList.add("pinut");
        mockMedicalRecord.setAllergies(mockAllergiesList);

    }

    @Test
    void testToString() {

        assertEquals("MedicalRecord{" +
                "firstName='" + mockMedicalRecord.getFirstName() +
                "', lastName='" + mockMedicalRecord.getLastName() +
                "', birthdate='" + mockMedicalRecord.getBirthdate() +
                "', medications='" + mockMedicalRecord.getMedications() +
                "', allergies='" + mockMedicalRecord.getAllergies() +
                "'}"
                , mockMedicalRecord.toString());

    }

    @Test
    void getFirstName() {
        mockMedicalRecord.setFirstName("Jean");

        assertEquals("Jean", mockMedicalRecord.getFirstName());
    }

    @Test
    void getLastName() {
      //  mockMedicalRecord.setLastName("Dupon");

        assertEquals("Dupon", mockMedicalRecord.getLastName());
    }

    @Test
    void getBirthdate() {
     //   mockMedicalRecord.setBirthdate("12/31/2000");

        assertEquals("12/31/2000", mockMedicalRecord.getBirthdate());
    }

    @Test
    void getMedications() {


        assertEquals(mockMedicationsList, mockMedicalRecord.getMedications());
    }

    @Test
    void getAllergies() {

        assertEquals(mockAllergiesList, mockMedicalRecord.getAllergies());
    }

    @Test
    void setFirstName() {
      //  mockMedicalRecord.setFirstName("Jean");

        assertEquals("Jean", mockMedicalRecord.getFirstName());
    }

    @Test
    void setLastName() {
     //   mockMedicalRecord.setLastName("Dupon");

        assertEquals("Dupon", mockMedicalRecord.getLastName());
    }

    @Test
    void setBirthdate() {
       // mockMedicalRecord.setBirthdate("12/31/2000");

        assertEquals("12/31/2000", mockMedicalRecord.getBirthdate());
    }

    @Test
    void setMedications() {
        mockMedicationsList.add("paracetamol:1000MG");
        mockMedicalRecord.setMedications(mockMedicationsList);

        assertEquals(mockMedicationsList, mockMedicalRecord.getMedications());
    }

    @Test
    void setAllergies() {
        mockAllergiesList.add("shellfish");
        mockMedicalRecord.setAllergies(mockAllergiesList);

        assertEquals(mockAllergiesList, mockMedicalRecord.getAllergies());
    }
}