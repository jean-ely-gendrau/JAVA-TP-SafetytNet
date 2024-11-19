package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.MedicalHistoryDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonMedicalHistoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    /**
     * Wired Repositories
     */
    private final PersonRepository personRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    /**
     * PersonService
     * Wire Repository
     *
     * @param personRepository
     * @param medicalRecordRepository
     */
    public PersonService(PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository) {
        this.personRepository = personRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    /**
     * findCommunityEmail
     *
     * @param city
     * @return
     */
    public List<String> findCommunityEmail(String city) {
        return personRepository
                .findByCity(city)
                .stream()
                .map(person -> person.getEmail())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<PersonMedicalHistoryDTO> findPersonInfo(String lastName, String firstName) {
        return personRepository.findAllByIdentity(lastName, firstName)
                .stream()
                .map(mapper -> {
                            MedicalRecord medicalRecordList = medicalRecordRepository.findByIdentity(mapper.getLastName(), mapper.getFirstName()).get(0);
                            String age = String.format("%.0f", Person.getAge(medicalRecordList.getBirthdate()));
                            return new PersonMedicalHistoryDTO(
                                    mapper.getLastName(),
                                    mapper.getAddress(),
                                    mapper.getEmail(),
                                    age,
                                    new MedicalHistoryDTO(medicalRecordList.getMedications(), medicalRecordList.getAllergies()));
                        }
                ).collect(Collectors.toList());
    }
}
