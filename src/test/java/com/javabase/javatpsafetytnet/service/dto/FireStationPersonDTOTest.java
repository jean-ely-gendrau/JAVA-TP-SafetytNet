package com.javabase.javatpsafetytnet.service.dto;

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
class FireStationPersonDTOTest {

    private FireStationPersonDTO fireStationPersonDTO;

    private final List<PersonContactDTO> personContactDTOList = new ArrayList<>();

    @BeforeEach
    void setUp(){

        String lastName = "Boyd";
        String firstName = "Julien";
        String address = "834 Binoc Ave";
        String phone = "111-111-111";

        PersonContactDTO personContactDTO = new PersonContactDTO(lastName, firstName, address,phone);

        personContactDTOList.add(personContactDTO);

        String firestation = "1";
        long personMinor = 1;
        long personMajor = 1;

         fireStationPersonDTO = new FireStationPersonDTO(
                "1",
                personContactDTOList,
                personMajor,
                personMinor
        );
    }

    @Test
    void getFirestation() {
        assertEquals("1", fireStationPersonDTO.getFirestation());
    }

    @Test
    void getPersonContactList() {
        assertEquals(personContactDTOList, fireStationPersonDTO.getPersonContactList());
    }

    @Test
    void getPersonMajor() {
        assertEquals(1, fireStationPersonDTO.getPersonMajor());
    }

    @Test
    void getPersonMinor() {
        assertEquals(1, fireStationPersonDTO.getPersonMinor());
    }

    @Test
    void setPersonContactList() {
        assertEquals(personContactDTOList, fireStationPersonDTO.getPersonContactList());
    }

    @Test
    void setFirestation() {
        assertEquals("1",fireStationPersonDTO.getFirestation());
    }

    @Test
    void setPersonMajor() {
        assertEquals(1, fireStationPersonDTO.getPersonMajor());
    }

    @Test
    void setPersonMinor() {
        assertEquals(1, fireStationPersonDTO.getPersonMinor());
    }
}