package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.FireStationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FireStationController.class)
class FireStationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FireStationService mockFireStationService;

    @Test
    void phoneAlert() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/phoneAlert?firestation=" + anyString()))
                    .andExpect(status().isOk());
        }catch(Exception e){
            // Handler to catch
        }
    }

    @Test
    void fireAlert() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fire?address="+anyString()))
                .andExpect(status().isOk());
    }

    @Test
    void floodStation() {
    }

    @Test
    void fireStation() {
    }
}