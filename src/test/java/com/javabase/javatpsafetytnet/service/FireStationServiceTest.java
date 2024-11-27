package com.javabase.javatpsafetytnet.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javabase.javatpsafetytnet.model.Data;
import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.DataRepository;
import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.MedicalHistoryDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonContactMedicalHistoryDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonsByStationDTO;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FireStationServiceTest {

    @Mock
    FireStationRepository mockFireStationRepository;

    @Mock
    PersonRepository mockPersonRepository;

    @Mock
    MedicalRecordRepository mockMedicalRecordRepository;

    @InjectMocks
    FireStationService fireStationService;

    private List<FireStation> fireStationList;
    private List<MedicalRecord> medicalRecordList;
    private List<Person> personList;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @BeforeEach
    void setUp() throws JsonProcessingException {
//        "fistNameA",
//                "lastNameA",
//                "address A",
//                "cityA",
//                "83000",
//                "111-111-111",
//                "email-a@test.com"
        MedicalRecord medicalRecordA = new MedicalRecord(
                "firstNameA",
                "lastNameA",
                LocalDate.now().minusYears(18).format(formatter),
                List.of("paracetamol:500mg"),
                List.of("peanuts")
        );

        MedicalRecord medicalRecordB = new MedicalRecord(
                "firstNameB",
                "lastNameB",
                LocalDate.now().minusYears(20).format(formatter),
                List.of("tramadol:2000mg"),
                List.of("water")
        );

        MedicalRecord medicalRecordC = new MedicalRecord(
                "firstNameC",
                "lastNameC",
                LocalDate.now().minusYears(8).format(formatter),
                List.of(),
                List.of()
        );

        this.medicalRecordList = new ArrayList<>();

        this.medicalRecordList.add(medicalRecordA);
        this.medicalRecordList.add(medicalRecordB);
        this.medicalRecordList.add(medicalRecordC);


        FireStation fireStationA = new FireStation(
                "address A",
                "1"
        );

        FireStation fireStationB = new FireStation(
                "address B",
                "1"
        );

        FireStation fireStationC = new FireStation(
                "address C",
                "2"
        );

        this.fireStationList = new ArrayList<>();

        this.fireStationList.add(fireStationA);
        this.fireStationList.add(fireStationB);
        this.fireStationList.add(fireStationC);

        Person personA = new Person(
                "firstNameA",
                "lastNameA",
                "address A",
                "cityA",
                "83000",
                "111-111-111",
                "email-a@test.com"
        );

        Person personB = new Person(
                "firstNameB",
                "lastNameB",
                "address B",
                "cityB",
                "83000",
                "222-222-222",
                "email-b@test.com"
        );

        Person personC = new Person(
                "firstNameC",
                "lastNameC",
                "address C",
                "cityC",
                "83000",
                "333-333-333",
                "email-c@gtest.com"
        );

        this.personList = new ArrayList<>();

        this.personList.add(personA);
        this.personList.add(personB);
        this.personList.add(personC);

    }

    @Test
    void getNumberPhoneByStation() {

        String stationNumber = "2";

        when(
                mockFireStationRepository.findByStation(anyString())
        ).thenReturn(
                List.of(
                        fireStationList.get(0).getAddress(),
                        fireStationList.get(1).getAddress()
                )
        );

        when(
                mockPersonRepository.findAll()
        ).thenReturn(personList);


        List<String> returned = fireStationService.getNumberPhoneByStation(stationNumber);

        assertEquals(2, returned.size());

        assertEquals(
                Arrays.asList("111-111-111", "222-222-222"),
                returned
        );

    }

    @Test
    void getAllPersonsByAddress() {
        String address = "address B";

        when(
                mockFireStationRepository.findByAddress(anyString())
        ).thenReturn(
                Optional.ofNullable(fireStationList.get(1))
        );

        when(
                mockPersonRepository.findAllByAddress(anyString())
        ).thenReturn(
                Collections.singletonList(personList.get(1))
        );


        when(
                mockMedicalRecordRepository.findAllByIdentity(anyString(), anyString())
        ).thenReturn(
                Collections.singletonList(medicalRecordList.get(1))
        );

        List<PersonContactMedicalHistoryDTO> personContactMedicalHistoryDTOList = new ArrayList<>();


        personContactMedicalHistoryDTOList.add(
                new PersonContactMedicalHistoryDTO(
                        personList.get(1).getLastName(),
                        personList.get(1).getPhone(),
                        String.format("%.0f", Person.getAge(medicalRecordList.get(1).getBirthdate())),
                        List.of(
                                new MedicalHistoryDTO(
                                        medicalRecordList.get(1).getMedications(),
                                        medicalRecordList.get(1).getAllergies()
                                )
                        )
                )
        );

        PersonsByStationDTO personsByStationDTOExcepted = new PersonsByStationDTO(
                "1",
                address,
                personContactMedicalHistoryDTOList
        );

        PersonsByStationDTO personsByStationDTO = fireStationService.getAllPersonsByAddress(address);

        assertNotNull(personsByStationDTO);
        assertEquals(personsByStationDTOExcepted.getPersonFireAlertList().get(0).getAge(), personsByStationDTO.getPersonFireAlertList().get(0).getAge());

        fireStationService.getAllPersonsByAddress(address);
    }

    @Test
    void getAllPersonsByStations() {
        String address = "address C";
        List<String> stationNumbers =new ArrayList<>();
        stationNumbers.add("1");
        stationNumbers.add("2");

        when(
                mockFireStationRepository.findAllByListStationNumber(
                       anyList()
                )
        ).thenReturn(
                        fireStationList
        );

        when(
                mockPersonRepository.findAllByAddress(anyString())
        ).thenReturn(
                personList
        );

        when(
                mockMedicalRecordRepository.findByIdentity(anyString(), anyString())
        ).thenReturn(
                medicalRecordList
        );


        List<PersonsByStationDTO> personsByStationDTOList = fireStationService.getAllPersonsByStations(stationNumbers);
        assertNotNull(personsByStationDTOList);
        assertEquals(personsByStationDTOList.size(), 3);
        assertEquals(personsByStationDTOList.get(2).getAddress(), address);
    }

    @Test
    void getAllPersonsByStation() {
    }
}