package com.javabase.javatpsafetytnet.model;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonTest {

    @Mock
    Comparable<String> firstName,
            lastName,
            address,
            city,
            zip,
            phone,
            email;

    @InjectMocks
    Person mockPerson;

    @BeforeEach
    void setUp() {

        mockPerson.setLastName("Jean");
        mockPerson.setFirstName("Luc");
        mockPerson.setEmail("jean@gmail.com");
        mockPerson.setPhone("111-111-111");
        mockPerson.setAddress("la valette");
        mockPerson.setCity("Toulon");
        mockPerson.setZip("83000");

    }

    @Test
    void testToString() {
        assertEquals("Person{" +
                "firstName='" + mockPerson.getFirstName() +
                "', lastName='" + mockPerson.getLastName() +
                "', address='" + mockPerson.getAddress() +
                "', city='" + mockPerson.getCity() +
                "', zip='" + mockPerson.getZip() +
                "', phone='" + mockPerson.getPhone() +
                "', email='" + mockPerson.getEmail() +
                "'}", mockPerson.toString()
        );
    }

    @Test
    void getAge() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDate localDate = LocalDate.now().minusYears(18);

        assertEquals(18.0 , Person.getAge(localDate.format(formatter)));
    }

    @Test
    void isAdult() {
        String birthDate = "12/31/2000";

        assertEquals(true , Person.isAdult(birthDate));
    }

    @Test
    void isAdultFalse() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate localDate = LocalDate.now();

        String birthDate =localDate.format(formatter);

        assertEquals(false , Person.isAdult(birthDate));
    }

    @Test
    void getFirstName() {
        assertEquals("Luc", mockPerson.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Jean", mockPerson.getLastName());
    }

    @Test
    void getAddress() {
        assertEquals("la valette", mockPerson.getAddress());
    }

    @Test
    void getCity() {
        assertEquals("Toulon", mockPerson.getCity());
    }

    @Test
    void getZip() {
        assertEquals("83000", mockPerson.getZip());
    }

    @Test
    void getPhone() {
        assertEquals("111-111-111",mockPerson.getPhone());
    }

    @Test
    void getEmail() {
        assertEquals("jean@gmail.com", mockPerson.getEmail());
    }

    @Test
    void setFirstName() {
        assertEquals("Luc", mockPerson.getFirstName());

    }

    @Test
    void setLastName() {
        assertEquals("Jean", mockPerson.getLastName());
    }

    @Test
    void setAddress() {
        assertEquals("la valette", mockPerson.getAddress());
    }

    @Test
    void setCity() {
        assertEquals("Toulon", mockPerson.getCity());
    }

    @Test
    void setZip() {
        assertEquals("83000", mockPerson.getZip());
    }

    @Test
    void setPhone() {
        assertEquals("111-111-111",mockPerson.getPhone());
    }

    @Test
    void setEmail() {
        assertEquals("jean@gmail.com", mockPerson.getEmail());
    }
}