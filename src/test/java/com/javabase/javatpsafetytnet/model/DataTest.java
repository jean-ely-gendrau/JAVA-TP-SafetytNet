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
        person.setFirstName("Ely");
        person.setEmail("jean@gmail.com");
        person.setAddress("la valette");
        person.setCity("Toulon");
        person.setZip("83000");

        personList.add(person);

        data.setPersons(personList);

        assertEquals(personList, data.getPersons());

        assertEquals("Jean", person.getLastName());
        assertEquals("Ely", person.getFirstName());
        assertEquals("jean@gmail.com", person.getEmail());
        assertEquals("la valette", person.getAddress());
        assertEquals("Toulon", person.getCity());
        assertEquals("83000", person.getZip());
    }

    @Test
    void setFirestations() {

    }

    @Test
    void setMedicalrecords() {
    }
}