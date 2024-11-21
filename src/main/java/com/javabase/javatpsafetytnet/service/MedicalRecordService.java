package com.javabase.javatpsafetytnet.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.ChildAlertDTO;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MedicalRecordService {

    /**
     * Wired Repositories
     */
    private final MedicalRecordRepository medicalRecordRepository;
    private final PersonRepository personRepository;

    private Mapper mapper;

    /**
     * MedicalRecordService
     * Wire Repository
     *
     * @param medicalRecordRepository
     * @param personRepository
     */
    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository, PersonRepository personRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.personRepository = personRepository;
    }

    /**
     * # getAllChildrenByAddress
     *
     * @param address
     * @return List ChildAlertDTO
     * @implNote Stream
     * <pre>
     * {@code
     *  medicalRecordRepository
     *                 .findAll()
     *                 .stream()
     * }
     * </pre>
     *
     * <p>This filter return true for all result match where predicate implement in filter</p>
     * <pre>
     * {@code
     * .filter(medicalRecord ->
     *     personList.stream()
     *               .allMatch(
     *                  person -> Objects.equals(person.getLastName(),
     *                  medicalRecord.getLastName())
     *                )
     *    )
     * }
     * </pre>
     *
     * <p>This filter static Person.isAdult return true for DataBirthday superior or equal at 18 year where predicate implement in filter</p>
     *
     * <pre>
     * {@code
     * .filter(medicalRecord -> !Person.isAdult(medicalRecord.getBirthdate()))
     * }
     * </pre>
     *
     * <p>map The mapper and declare in lambas a new instance of your DTO data and map the Data Entity in DataDTO match properties and returns the best data for api.</p>
     *
     * <pre>
     * {@code
     * .map(mapper ->
     *  new ChildAlertDTO(
     *        mapper.getFirstName(),
     *        mapper.getLastName(),
     *  Person.getAge(mapper.getBirthdate()),
     *  personList
     *     .stream()
     *    .filter(person -> Objects.equals(person.getLastName(), mapper.getLastName()))
     *    .toList()
     *   )
     * )
     * }
     * </pre>
     */
    public List<ChildAlertDTO> getAllChildrenByAddress(String address) {
        List<Person> personList = personRepository.findAllByAddress(address);
       // ObjectMapper objectMapper = new ObjectMapper();
        return medicalRecordRepository
                .findAll()
                .stream()

                // Filter All persons match with lastName
                .filter(medicalRecord ->
                        personList.stream()
                                .allMatch(
                                        person -> Objects.equals(person.getLastName(), medicalRecord.getLastName())
                                )
                )

                // Filter Match isAdult return false to select a minorPerson
                .filter(medicalRecord -> !Person.isAdult(medicalRecord.getBirthdate()))

                // MAPPING DATA TO DTO MODEL ChildAlertDTO
                .map(mapper ->
                        new ChildAlertDTO(
                                mapper.getFirstName(),
                                mapper.getLastName(),
                                Person.getAge(mapper.getBirthdate()),
                                personList
                                        .stream()
                                        .filter(person -> Objects.equals(person.getLastName(), mapper.getLastName()) != Objects.equals(person.getFirstName(), mapper.getFirstName()))
                                        .toList()
                        )
                )
                // Collect to ChildAlertDTO
                .collect(Collectors.toList());
    }
}
