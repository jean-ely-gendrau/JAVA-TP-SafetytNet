package com.javabase.javatpsafetytnet.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    private final DataRepository dataRepository;

    public PersonRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<String> findByCity(String city) {
        return dataRepository
                .getData()
                .getPersons()
                .stream()
                .filter( person ->
                        Objects.equals(person.getCity(), city)
                ).map(person -> person.getEmail())
                .collect(Collectors.toList());
    }

}