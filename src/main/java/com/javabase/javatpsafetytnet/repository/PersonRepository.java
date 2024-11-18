package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    /**
     * Wired Repository
     */
    private final DataRepository dataRepository;

    /**
     * Constructor
     * Wire repository
     *
     * @param dataRepository
     */
    public PersonRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * findAll
     *
     * @return List Person
     */
    public List<Person> findAll(){
        return dataRepository
                .findAllPeron();
    }

    /**
     * findByCity
     *
     * @param city
     * @return List Person
     */
    public List<Person> findByCity(String city) {
        return dataRepository
                .findAllPeron()
                .stream()
                .filter( person ->
                        Objects.equals(person.getCity(), city)
                )
                .collect(Collectors.toList());
    }

    /**
     * findAllByAddress
     *
     * @param address
     * @return List Person
     */
    public List<Person> findAllByAddress(String address){
        return dataRepository.findAllPeron()
                .stream()
                .filter(person -> Objects.equals(person.getAddress(), address))
                .collect(Collectors.toList());
    }
}