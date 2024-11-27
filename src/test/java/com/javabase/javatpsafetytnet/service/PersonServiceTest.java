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
import static org.mockito.Mockito.*;

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
    void addNewPerson() throws Exception {
        Person personRequest = new Person();

        personRequest.setLastName("TestJohn");
        personRequest.setFirstName("TestSmith");
        personRequest.setAddress("test Address");
        personRequest.setPhone("111-222-333");
        personRequest.setCity("Test");
        personRequest.setZip("83000");
        personRequest.setEmail("Testemail@test.com");

        doNothing().when(mockPersonRepository).save(any(Person.class));

        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(new Person());

        personService.addPerson(personRequest);

        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(personRequest);

        Person personActual = mockPersonRepository.findByIdentity(personRequest.getLastName(), personRequest.getFirstName());

        assertEquals(personRequest.getLastName(), personActual.getLastName() );
        assertEquals(personRequest.getFirstName(), personActual.getFirstName());

        verify(mockPersonRepository, times(2)).findByIdentity(personRequest.getLastName(),
                personRequest.getFirstName());
    }
}