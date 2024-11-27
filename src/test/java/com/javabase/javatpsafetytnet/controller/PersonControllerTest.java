package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.PersonService;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    PersonService mockPersonService;

    @MockBean
    PersonRepository mockPersonRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getCommunityEmail() throws Exception {
//        List<String> personList = new ArrayList<>();
//        personList.add("841-874-6513");
//        personList.add("841-874-6514");
//        when(mockPersonService.findCommunityEmail(anyString())).thenReturn(personList);

        mockMvc.perform(MockMvcRequestBuilders.get("/communityEmail?city=ville"))
                .andExpect(status().isOk()
                );
        //.andExpect(content().json(String.valueOf(List.copyOf(personList).stream().toList())));
    }

    @Test
    void getPersonInfo() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/personInfo?lastName=" + anyString() + "&firstName=" + anyString()))
                .andExpect(status().isOk()
                );
    }

    @Test
    void addNewPerson() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/addPerson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(anyString())
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}