package com.javabase.javatpsafetytnet.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FireStationTest {

    @Mock
    Comparable<String> address, station;

    @InjectMocks
    FireStation mockFireStation;

    @Test
    void getAddress() {
        FireStation fireStation = new FireStation();

        fireStation.setAddress("la valette");

        assertEquals("la valette", fireStation.getAddress());
    }

    @Test
    void getStation() {
        FireStation fireStation = new FireStation();

        fireStation.setStation("1");

        assertEquals("1", mockFireStation.getStation());
    }

    @Test
    void setAddress() {
        FireStation fireStation = new FireStation();
        fireStation.setStation("1");

        assertEquals("1", fireStation.getStation());
    }

    @Test
    void setStation() {
        FireStation fireStation = new FireStation();
        fireStation.setAddress("la valette");

        assertEquals("la valette", fireStation.getAddress());
    }
}