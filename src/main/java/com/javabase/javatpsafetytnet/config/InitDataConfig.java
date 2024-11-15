package com.javabase.javatpsafetytnet.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.javabase.javatpsafetytnet.model.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class InitDataConfig {

    @Bean
    CommandLineRunner initData(){
        return args -> {
            Data data = new Data();
        };
    }

}
