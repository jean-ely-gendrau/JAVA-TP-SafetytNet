package com.javabase.javatpsafetytnet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DataTest {

    @Mock
    List<Person> mockPersonList;

    @Mock
    List<FireStation> mockFirestationList;

    @Mock
    List<MedicalRecord> mockMedicalRecords;

    @InjectMocks
    Data data;

    @Test
    void getPersons() {

    }

    @Test
    void getFirestations() {
    }

    @Test
    void getMedicalrecords() {
    }

    @Test
    void setPersons() {

        List<Person> personList = new ArrayList<>();

        Person person = new Person();
        person.setLastName("Jean");
        person.setFirstName("Luc");
        person.setEmail("jean@gmail.com");
        person.setPhone("111-111-111");
        person.setAddress("la valette");
        person.setCity("Toulon");
        person.setZip("83000");

        personList.add(person);

        data.setPersons(personList);

        assertEquals(personList, data.getPersons());

        assertEquals("Jean", person.getLastName());
        assertEquals("Luc", person.getFirstName());
        assertEquals("jean@gmail.com", person.getEmail());
        assertEquals("111-111-111",person.getPhone());
        assertEquals("la valette", person.getAddress());
        assertEquals("Toulon", person.getCity());
        assertEquals("83000", person.getZip());
    }

    @Test
    void setFirestations() {

        List<FireStation> fireStationsList = new ArrayList<>();

        FireStation fireStation = new FireStation();
        fireStation.setAddress("la valette");
        fireStation.setStation("1");

        fireStationsList.add(fireStation);

        data.setFirestations(fireStationsList);

        assertEquals(fireStationsList, data.getFirestations());
    }

    @Test
    void setMedicalrecords() {
        List<MedicalRecord> medicalRecordsList = new ArrayList<>();
        List<String> medication = new ArrayList<>();
        List<String> allergie = new ArrayList<>();

        medication.add("tramadol:2000MG");
        allergie.add("peanut");

        MedicalRecord medicalRecord = new MedicalRecord();

        medicalRecord.setMedications(medication);
        medicalRecord.setAllergies(allergie);

        medicalRecordsList.add(medicalRecord);

        data.setMedicalrecords(medicalRecordsList);

        assertEquals(medicalRecordsList, data.getMedicalrecords());
    }
}