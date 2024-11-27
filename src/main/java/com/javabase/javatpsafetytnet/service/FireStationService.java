package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FireStationService {

    private static final Logger log = LoggerFactory.getLogger(FireStationService.class);
    /**
     * Wired Repositories
     */
    private final FireStationRepository fireStationRepository;
    private final PersonRepository personRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    /**
     * Constructor
     * Wire Repositories
     *
     * @param fireStationRepository
     * @param personRepository
     */
    public FireStationService(FireStationRepository fireStationRepository, PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }

    /**
     * getNumberPhoneByStation
     *
     * @param stationNumber
     * @return List String
     */
    public List<String> getNumberPhoneByStation(String stationNumber) {
        // Find All Station match with stationNumber params
        List<String> stationAddress = fireStationRepository.findByStation(stationNumber);

        // Return all Phone Number match with all stationAddress List
        return personRepository.findAll()
                .stream()
                .filter(persone -> stationAddress.contains(persone.getAddress()))
                // Return phone in result
                .map(Person::getPhone)
                // Remove duplicate data
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * getAllPersonsByAddress
     *
     * @param address
     * @return PersonContactMedicalHistoryDTO
     */
    public PersonsByStationDTO getAllPersonsByAddress(String address) {
        Optional<FireStation> fireStation = fireStationRepository.findByAddress(address);

        List<PersonContactMedicalHistoryDTO> personList = personRepository.findAllByAddress(address)
                .stream()

                // MAPPING DATA TO DTO MODEL PersonContactMedicalHistoryDTO
                .map(mapper -> {
                            // Find birthdate
                            String dateString = medicalRecordRepository
                                    .findAllByIdentity(mapper.getLastName(), mapper.getFirstName())
                                    .get(0)
                                    .getBirthdate();

                            // Return PersonContactMedicalHistoryDTO
                            return new PersonContactMedicalHistoryDTO(
                                    mapper.getLastName(),
                                    mapper.getPhone(),
                                    String.format("%.0f", Person.getAge(dateString)),
                                    // FIND MEDICAL RECORD By Identity
                                    medicalRecordRepository.findAllByIdentity(mapper.getLastName(), mapper.getFirstName())
                                            .stream()
                                            .map(mapperMRR ->
                                                    new MedicalHistoryDTO(
                                                            mapperMRR.getMedications(),
                                                            mapperMRR.getAllergies()
                                                    )
                                            ).toList()
                            );
                        }
                )
                // Collect PersonContactMedicalHistoryDTO
                .collect(Collectors.toList());


        return new PersonsByStationDTO(fireStation.get().getStation(), address, personList);
    }

    /**
     * getAllPersonsByStations
     *
     * @param stationsNumber
     * @return List PersonsByStationDTO
     */
    public List<PersonsByStationDTO> getAllPersonsByStations(List<String> stationsNumber) {
        return fireStationRepository.findAllByListStationNumber(stationsNumber)
                .stream()
                // MAPPING DATA TO DTO MODEL PersonsByStationDTO
                .map(mapper ->
                        new PersonsByStationDTO(
                                mapper.getStation(),
                                mapper.getAddress(),
                                personRepository.findAllByAddress(mapper.getAddress())
                                        .stream()

                                        // MAPPING DATA TO DTO MODEL PersonContactMedicalHistoryDTO
                                        .map(mapperPerson ->
                                                {
                                                    try {
                                                        List<MedicalRecord> medicalRecordList =
                                                                medicalRecordRepository.findByIdentity(mapperPerson.getLastName(), mapperPerson.getFirstName());

                                                        double ageOfPerson =
                                                                Person.getAge(medicalRecordList
                                                                        .get(0)
                                                                        .getBirthdate());

                                                        return new PersonContactMedicalHistoryDTO(
                                                                mapperPerson.getLastName(),
                                                                mapperPerson.getPhone(),
                                                                // Find BirthDate and String AGE format
                                                                String.format("%.0f",
                                                                        ageOfPerson
                                                                ),
                                                                // Find Medical Records
                                                                medicalRecordList
                                                                        .stream()

                                                                        // MAPPING DATA TO DTO MODEL MedicalHistoryDTO
                                                                        .map(mapperMedical ->

                                                                                new MedicalHistoryDTO(
                                                                                        mapperMedical.getMedications(),
                                                                                        mapperMedical.getAllergies()
                                                                                )

                                                                        )
                                                                        // Collect Medical records
                                                                        .collect(Collectors.toList())
                                                        );
                                                    } catch (IndexOutOfBoundsException e) {

                                                        log.error("Error found data for person lastname : {}, : {}",
                                                                mapperPerson.getLastName(), mapperPerson.getFirstName());

                                                        return new PersonContactMedicalHistoryDTO();
                                                    }
                                                }
                                        )
                                        // COLLECT DATA PersonContactMedicalHistoryDTO
                                        .collect(Collectors.toList())
                        )

                )
                // COLLECT DATA PersonsByStationDTO
                .collect(Collectors.toList());
    }

    /**
     * getAllPersonsByStation
     *
     * @param stationNumber
     * @return
     */
    public List<FireStationPersonDTO> getAllPersonsByStation(String stationNumber) {
        try {

            return fireStationRepository.findAllByStationNumber(stationNumber)
                    .stream()

                    // MAPPING DATA TO DTO MODEL FireStationPersonDTO
                    .map(mapper -> {

                                List<Person> personList = personRepository.findAllByAddress(mapper.getAddress());
                                // COUNT MAJOR
                                long countMajor = personList.stream()
                                        .filter(person -> {

                                                    String birthDate = medicalRecordRepository.findByIdentity(person.getLastName(), person.getFirstName())
                                                            .get(0)
                                                            .getBirthdate();

                                                    return Person.isAdult(birthDate);

                                                }
                                        )
                                        .count();

                                return new FireStationPersonDTO(
                                        mapper.getStation(),
                                        personList
                                                .stream()

                                                // MAPPING DATA TO DTO MODEL PersonContactDTO
                                                .map(person ->

                                                        new PersonContactDTO(
                                                                person.getFirstName(),
                                                                person.getLastName(),
                                                                person.getAddress(),
                                                                person.getPhone()
                                                        )

                                                )
                                                // COLLETE DATA to DTO PersonContactDTO
                                                .collect(Collectors.toList()),


                                        countMajor,
                                        personList.size() - countMajor

                                );
                            }

                    )
                    // RETURN COLLETE DATA
                    .collect(Collectors.toList());

        } catch (IndexOutOfBoundsException e) {
            log.error("Error found data for station number {}", stationNumber);
            return List.of(new FireStationPersonDTO());
        }
    }
}
