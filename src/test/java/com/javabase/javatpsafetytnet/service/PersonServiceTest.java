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

    private Person personTestAdd;

    @BeforeEach
    void setUp() throws Exception {
        personTestAdd = new Person();

        personTestAdd.setLastName("TestJohn");
        personTestAdd.setFirstName("TestSmith");
        personTestAdd.setAddress("test Address");
        personTestAdd.setPhone("111-222-333");
        personTestAdd.setCity("Test");
        personTestAdd.setZip("83000");
        personTestAdd.setEmail("Testemail@test.com");


    }

    @Test
    void findCommunityEmail() {
    }

    @Test
    void findPersonInfo() {
    }

    @Test
    void addNewPerson() throws Exception {
        doNothing().when(mockPersonRepository).save(any(Person.class));

        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(new Person());

        personService.addPerson(personTestAdd);

        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(personTestAdd);

        Person personActual = mockPersonRepository.findByIdentity(personTestAdd.getLastName(), personTestAdd.getFirstName());

        assertNotNull(personActual);
        assertEquals(personTestAdd.getLastName(), personActual.getLastName());
        assertEquals(personTestAdd.getFirstName(), personActual.getFirstName());

        verify(mockPersonRepository, times(2)).findByIdentity(personTestAdd.getLastName(),
                personTestAdd.getFirstName());
    }

    @Test
    void updatePerson() throws Exception {
        doNothing().when(mockPersonRepository).save(any(Person.class));

        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(personTestAdd);

        Person personUpdate = personService.updatePerson(personTestAdd);

        assertNotNull(personUpdate);

        assertEquals(personTestAdd.getLastName(), personUpdate.getLastName());
        assertEquals(personTestAdd.getFirstName(), personUpdate.getFirstName());
    }

    @Test
    void deletePerson() throws Exception {
        doNothing().when(mockPersonRepository).delete(anyString(), anyString());

        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(personTestAdd);

        String firstName = personTestAdd.getFirstName();
        String lastName = personTestAdd.getLastName();

        personService.delete(lastName, firstName);

        Person person = mockPersonRepository.findByIdentity(lastName, firstName);

        assertNull(person);
    }

}