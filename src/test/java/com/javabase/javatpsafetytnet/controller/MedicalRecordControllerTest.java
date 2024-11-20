package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.MedicalRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MedicalRecordController.class)
class MedicalRecordControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MedicalRecordService medicalRecordService;

    @Test
    void childAlert() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/childAlert?address=" + anyString())).andExpect(status().isOk()
        );
    }
}