package com.javabase.javatpsafetytnet.service.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PersonContactDTOTest {

    @Mock
    Comparable<String> firstName, lastName, address, phone;

    @InjectMocks
    PersonContactDTO mockPersonContactDTO;

    @BeforeEach
    void setUp() {
        mockPersonContactDTO.setFistName("Test");
        mockPersonContactDTO.setLastName("Unit");
        mockPersonContactDTO.setAddress("1509 Culver St");
        mockPersonContactDTO.setPhone("111-111-111");
    }

    @Test
    void getFistName() {
        assertEquals("Test", mockPersonContactDTO.getFistName());
    }

    @Test
    void getLastName() {
        assertEquals("Unit", mockPersonContactDTO.getLastName());
    }

    @Test
    void getAddress() {
        assertEquals("1509 Culver St", mockPersonContactDTO.getAddress());
    }

    @Test
    void getPhone() {
        assertEquals("111-111-111", mockPersonContactDTO.getPhone());
    }

    @Test
    void setFistName() {
        assertEquals("Test", mockPersonContactDTO.getFistName());
    }

    @Test
    void setLastName() {
        assertEquals("Unit", mockPersonContactDTO.getLastName());
    }

    @Test
    void setAddress() {
        assertEquals("1509 Culver St", mockPersonContactDTO.getAddress());
    }

    @Test
    void setPhone() {
        assertEquals("111-111-111", mockPersonContactDTO.getPhone());
    }
}