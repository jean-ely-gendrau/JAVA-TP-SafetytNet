
package com.javabase.javatpsafetytnet.service.dto;

import com.javabase.javatpsafetytnet.model.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChildAlertDTOTest {

    @Mock
    Comparable<String> firstName,
            lastName;

    @Mock
    Comparable<Double> age;

    @Mock
    List<Person> mockPersonList;

    @InjectMocks
    ChildAlertDTO childAlertDTO;

    @BeforeEach
    void setUp() {
        Person person = new Person();

        mockPersonList = new ArrayList<>();
        mockPersonList.add(person);

        childAlertDTO = new ChildAlertDTO();
        childAlertDTO.setFirstName("FirstName");
        childAlertDTO.setLastName("LastName");
        childAlertDTO.setAge(18.0);
        childAlertDTO.setFamilyMembers(mockPersonList);
    }

    @Test
    void getFirstName() {
        assertEquals("FirstName", childAlertDTO.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("LastName", childAlertDTO.getLastName());
    }

    @Test
    void getAge() {
        assertEquals(Double.valueOf(18.0), childAlertDTO.getAge());
    }

    @Test
    void getFamilyMembers() {
        assertEquals(mockPersonList, childAlertDTO.getFamilyMembers());
    }

    @Test
    void setFirstName() {
        assertEquals("FirstName", childAlertDTO.getFirstName());
    }

    @Test
    void setLastName() {
        assertEquals("LastName", childAlertDTO.getLastName());
    }

    @Test
    void setAge() {
        assertEquals(Double.valueOf(18.0), childAlertDTO.getAge());
    }

    @Test
    void setFamilyMembers() {
        assertEquals(mockPersonList, childAlertDTO.getFamilyMembers());
    }
}