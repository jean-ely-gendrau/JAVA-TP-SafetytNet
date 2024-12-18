package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    public List<Person> findAll() {
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
                .filter(person ->
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
    public List<Person> findAllByAddress(String address) {
        return dataRepository.findAllPeron()
                .stream()
                .filter(person -> Objects.equals(person.getAddress(), address))
                .collect(Collectors.toList());
    }

    /**
     * findAllByIdentity
     *
     * @param lastName
     * @param firstName
     * @return List Person
     */
    public List<Person> findAllByIdentity(String lastName, String firstName) {
        return dataRepository.findAllPeron()
                .stream()
                .filter(person -> Objects.equals(person.getFirstName(), firstName) || Objects.equals(person.getLastName(), lastName))
                .collect(Collectors.toList());
    }

    /**
     * findByIdentity
     *
     * @param lastName
     * @param firstName
     * @return Person
     */
    public Person findByIdentity(String lastName, String firstName) {
        return dataRepository.findAllPeron()
                .stream()
                .filter(person ->
                        Objects.equals(person.getLastName(), lastName) && Objects.equals(person.getFirstName(), firstName)
                ).findFirst()
                .orElse(new Person());
    }

    /**
     * save
     *
     * @param person
     */
    public void save(Person person) {
       dataRepository.addPersonToList(person);
    }

    /**
     * update
     *
     * @param person
     */
    public void update(Person person) {
        dataRepository.updatePersonToList(person);
    }


    /**
     * update
     *
     * @param lastName
     * @param firstName
     */
    public void delete(String lastName, String firstName) {
        dataRepository.deletePersonToList(lastName, firstName);
    }
}