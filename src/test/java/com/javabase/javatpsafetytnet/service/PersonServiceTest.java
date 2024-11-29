//package com.javabase.javatpsafetytnet.service;
//
//import com.javabase.javatpsafetytnet.model.Data;
//import com.javabase.javatpsafetytnet.model.FireStation;
//import com.javabase.javatpsafetytnet.model.MedicalRecord;
//import com.javabase.javatpsafetytnet.model.Person;
//import com.javabase.javatpsafetytnet.repository.DataRepository;
//import com.javabase.javatpsafetytnet.repository.FireStationRepository;
//import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
//import com.javabase.javatpsafetytnet.repository.PersonRepository;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class PersonServiceTest {
//
//    @Mock
//    DataRepository mockDataRepository;
//
//    @Mock
//    PersonRepository mockPersonRepository;
//
//    @Mock
//    FireStationRepository mockFireStationRepository;
//
//    @Mock
//    MedicalRecordRepository mockRecordRepository;
//
//    @InjectMocks
//    PersonService personService;
//
//    private Person personTestAdd;
//
//    private List<FireStation> fireStationList;
//    private List<MedicalRecord> medicalRecordList;
//    private List<Person> personList;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//
//        this.personTestAdd = new Person();
//
//        this.personTestAdd.setLastName("TestJohn");
//        this.personTestAdd.setFirstName("TestSmith");
//        this.personTestAdd.setAddress("test Address");
//        this.personTestAdd.setPhone("111-222-333");
//        this.personTestAdd.setCity("Test");
//        this.personTestAdd.setZip("83000");
//        this.personTestAdd.setEmail("Testemail@test.com");
//
//
//
//        doNothing().when(mockPersonRepository).save(any(Person.class));
////        doNothing().when(mockDataRepository).addPersonToList(personTestAdd);
////        when(mockData.getPersons()).thenReturn(mockData.getPersons());
////        when(mockData.getPersons().add(personTestAdd)).thenReturn(true);
//
//        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(new Person());
//
//        personService.addPerson(personTestAdd);
//
//        verify(mockPersonRepository,times(1)).save(personTestAdd);
////        verify(mockDataRepository, times(2)).addPersonToList(personTestAdd);
//    }
//
//    @Test
//    void findCommunityEmail() {
//    }
//
//    @Test
//    void findPersonInfo() {
//    }
//
//    @Test
//    void addNewPerson() throws Exception {
//        Person addPersonNew = new Person();
//
//        addPersonNew.setLastName("TestJohn2");
//        addPersonNew.setFirstName("TestSmith2");
//        addPersonNew.setAddress("test Address2");
//        addPersonNew.setPhone("888-777-666");
//        addPersonNew.setCity("Test2");
//        addPersonNew.setZip("75000");
//        addPersonNew.setEmail("Testemail2@test.com");
//
//        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(new Person());
//
//        doNothing().when(mockPersonRepository).save(any(Person.class));
////        doNothing().when(mockDataRepository).addPersonToList(any(Person.class));
//
////        when(mockData.getPersons()).thenReturn(Collections.singletonList(any(Person.class)));
////        when(mockData.getPersons().add(any(Person.class))).thenReturn(true);
//
//
//        personService.addPerson(addPersonNew);
//
//        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(addPersonNew);
//
//        Person personActual = mockPersonRepository.findByIdentity(addPersonNew.getLastName(), addPersonNew.getFirstName());
//
//        assertNotNull(personActual);
//        assertEquals(addPersonNew.getLastName(), personActual.getLastName());
//        assertEquals(addPersonNew.getFirstName(), personActual.getFirstName());
//
////        verify(mockDataRepository, times(1)).addPersonToList(addPersonNew);
//        verify(mockPersonRepository, times(1)).save(addPersonNew);
//
//    }
//
//    @Test
//    void updatePerson() throws Exception {
//        Person personToUpdate = new Person();
//
//        personToUpdate.setLastName(personTestAdd.getLastName());
//        personToUpdate.setFirstName(personTestAdd.getFirstName());
//
//        personToUpdate.setAddress("Test Update");
//        personToUpdate.setPhone("999-999-999");
//
////        doNothing().when(mockDataRepository).updatePersonToList(any(Person.class));
//        doNothing().when(mockPersonRepository).update(any(Person.class));
//
////        when(mockData.getPersons()).thenReturn(Collections.singletonList(any(Person.class)));
//        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(personTestAdd);
//
//
//        Person personActual = personService.updatePerson(personToUpdate);
//
//        assertNotNull(personActual);
//
//        assertEquals(personToUpdate.getLastName(), personActual.getLastName());
//        assertEquals(personToUpdate.getFirstName(), personActual.getFirstName());
//
////        verify(mockDataRepository, times(1)).updatePersonToList(personToUpdate);
//        verify(mockPersonRepository, times(1)).update(personToUpdate);
//
//
//        assertEquals("Test Update", personToUpdate.getAddress());
//        assertEquals("999-999-999", personToUpdate.getPhone());
//    }
//
//    @Test
//    void deletePerson() throws Exception {
//        doNothing().when(mockPersonRepository).delete(anyString(), anyString());
//
//        when(mockPersonRepository.findByIdentity(anyString(), anyString())).thenReturn(personTestAdd);
////        when(mockData.getPersons()).thenReturn(Collections.singletonList(any(Person.class)));
////
////        doNothing().when(mockData).setPersons(Collections.singletonList(any(Person.class)));
//        doNothing().when(mockPersonRepository).delete(anyString(), anyString());
//
//        String firstName = personTestAdd.getFirstName();
//        String lastName = personTestAdd.getLastName();
//
//        String deletePerson = personService.deletePerson(lastName, firstName);
//
//        Person person = mockPersonRepository.findByIdentity(lastName, firstName);
//
//        assertNull(person);
//        assertEquals(lastName + ", " + firstName, deletePerson);
//
//        verify(mockPersonRepository, times(1)).findByIdentity(lastName, firstName);
//    }
//
//}