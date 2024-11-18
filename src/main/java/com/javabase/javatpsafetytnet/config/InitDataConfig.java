package com.javabase.javatpsafetytnet.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.repository.DataRepository;
import com.javabase.javatpsafetytnet.utils.IJsonUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class InitDataConfig implements IJsonUtils {

    // Declare Service Data
    private final DataRepository dataRepository;

    // Wire Service Data
    public InitDataConfig(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    // Bean of command runner mapping data Json with library Jackson
    @Bean
    public CommandLineRunner runner(){

        return args -> {
            // Load Data
            jsonFileToMap("data.json");
        };
    }

    @Override
    public void jsonFileToMap(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dataRepository.setData(objectMapper.readValue(new File(path), Data.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
