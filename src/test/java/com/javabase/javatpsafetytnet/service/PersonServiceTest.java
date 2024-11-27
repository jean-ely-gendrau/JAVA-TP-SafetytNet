package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonRepository mockPersonRepository;

    @Mock
    FireStationRepository mockFireStationRepository;

    @Mock
    MedicalRecordRepository mockRecordRepository;

    @InjectMocks
    PersonService personService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findCommunityEmail() {
    }

    @Test
    void findPersonInfo() {
    }

    @Test
    void addNewPerson() {
        Person personRequest = new Person();

        personRequest.setLastName("John");
        personRequest.setFirstName("Smith");
        personRequest.setAddress("test Address");
        personRequest.setPhone("111-222-333");
        personRequest.setCity("Test");
        personRequest.setZip("83000");
        personRequest.setEmail("email@test.com");

        when(
                mockPersonRepository.save(any(Person.class))
        ).thenReturn(
                personRequest
        );

        personService.addPerson(personRequest);

        Person personActual = personService.findByIdentity(personRequest.getLastName(), personRequest.getLastName());

        assertEquals(personRequest.getLastName(), personActual.getLastName() );
        assertEquals(personRequest.getFirstName(), personActual.getFirstName());
    }
}