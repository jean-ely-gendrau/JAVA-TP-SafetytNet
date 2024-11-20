package com.javabase.javatpsafetytnet.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.repository.DataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InitDataConfigTest {

    @Mock
    DataRepository dataRepository;

    @InjectMocks
    InitDataConfig initDataConfig;

//    @Test
//    void runnerJsonFileToMapThrow() throws IOException {
//        when(initDataConfig.runner()).thenReturn(args->{
//            initDataConfig.jsonFileToMap("dataz.json");
//        });
//
//        initDataConfig.runner();
//
//
//     //  assertTrue(exception.getMessage().contains("Error loading JSON file : dataz.json"));
//
//    }

    @Test
    void jsonFileToMapThrow() {
        String file = "dataz.json";
        File fileMock = mock(File.class);
        ObjectMapper objectMapperMock = mock(ObjectMapper.class);

//        when(objectMapperMock.readValue(fileMock, Data.class)).thenThrow(
//                new IOException("File not found")
//        );

        IOException exception = assertThrows(IOException.class, () ->
            initDataConfig.jsonFileToMap(file)
        );

        // Verify exception message
        assertTrue(exception.getMessage().contains("Error reading or paring JSON file : dataz.json"));

    }
}