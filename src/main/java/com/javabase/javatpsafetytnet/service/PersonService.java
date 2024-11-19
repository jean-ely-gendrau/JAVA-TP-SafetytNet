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
                // Unique
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * findPersonInfo
     *
     * @param lastName
     * @param firstName
     * @return List PersonMedicalHistoryDTO
     */
    public List<PersonMedicalHistoryDTO> findPersonInfo(String lastName, String firstName) {
        return personRepository.findAllByIdentity(lastName, firstName)
                .stream()
                // MAPPING DATA TO DTO MODEL PersonMedicalHistoryDTO
                .map(mapper -> {

                            // Find medical records of person by lastName and firstName
                            MedicalRecord medicalRecordList = medicalRecordRepository.findByIdentity(mapper.getLastName(), mapper.getFirstName()).get(0);
                            // Format Age
                            String age = String.format("%.0f", Person.getAge(medicalRecordList.getBirthdate()));

                            // lambdas Return model PersonMedicalHistoryDTO
                            return new PersonMedicalHistoryDTO(
                                    mapper.getLastName(),
                                    mapper.getAddress(),
                                    mapper.getEmail(),
                                    age,
                                    // Inject Instance of Model MedicalHistoryDTO
                                    new MedicalHistoryDTO(medicalRecordList.getMedications(), medicalRecordList.getAllergies()));
                        }
                )
                // Return Collect Data to PersonMedicalHistoryDTO
                .collect(Collectors.toList());
    }
}
