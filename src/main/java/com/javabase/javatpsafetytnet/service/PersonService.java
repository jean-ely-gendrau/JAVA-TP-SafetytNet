package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.MedicalHistoryDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonMedicalHistoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);
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

    /**
     * addPerson
     *
     * @param person
     * @return Person
     */
    public Person addPerson(Person person) throws Exception {
        Optional<Person> personExist = Optional.ofNullable(personRepository.findByIdentity(person.getLastName(),
                person.getFirstName()));

        if (personExist.isPresent() && Objects.equals(personExist.get().getFirstName(), person.getFirstName()) &&
                        Objects.equals(personExist.get().getLastName(), person.getLastName())
        ) {
            log.error("User exist verify your data {}", person);
            throw new Exception("User exist verify your data");
        }

        personRepository.save(person);

        return person;
    }

    /**
     * updatePerson
     *
     * @param person
     * @return
     * @throws Exception
     */
    public Person updatePerson(Person person) throws Exception {
        Optional<Person> personExist = Optional.ofNullable(personRepository.findByIdentity(person.getLastName(),
                person.getFirstName()));

        if(personExist.isPresent() &&!Objects.equals(personExist.get().getFirstName(), person.getFirstName())){
           throw new Exception("Person does not exist");
        }

         personRepository.update(person);

        return  personRepository.findByIdentity(person.getLastName(), person.getFirstName());
    }

    /**
     * deletePerson
     *
     * @param lastName
     * @param firstName
     * @return boolean
     * @throws Exception
     */
    public  String deletePerson(String lastName, String firstName) throws Exception {
        Optional<Person> personExist = Optional.ofNullable(personRepository.findByIdentity(lastName, firstName));

        if(personExist.isPresent() && !Objects.equals(personExist.get().getFirstName(), firstName)){
            throw new Exception("Person does not exist");
        }

        personRepository.delete(lastName, firstName);

        return lastName + ", " + firstName + " as removed";
    }
}
