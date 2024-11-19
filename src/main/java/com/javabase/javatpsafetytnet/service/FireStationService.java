package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.MedicalHistoryDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonFireAlertDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonsFireStationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FireStationService {

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
                .map(Person::getPhone)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * getAllPersonsByAddress
     *
     * @param address
     * @return PersonFireAlertDTO
     */
    public PersonsFireStationDTO getAllPersonsByAddress(String address) {
        Optional<FireStation> fireStation = fireStationRepository.findByAddress(address);

        List<PersonFireAlertDTO> personList = personRepository.findAllByAddress(address)
                .stream()
                .map(mapper -> {
                            String dateString = medicalRecordRepository
                                    .findAllByIdentity(mapper.getLastName(), mapper.getFirstName())
                                    .get(0)
                                    .getBirthdate();

                            return new PersonFireAlertDTO(
                                    mapper.getLastName(),
                                    mapper.getPhone(),
                                    String.format("%.0f", Person.getAge(dateString)),
                                    medicalRecordRepository.findAllByIdentity(mapper.getLastName(), mapper.getFirstName())
                                            .stream()
                                            .map(mapperMRR -> new MedicalHistoryDTO(
                                                            mapperMRR.getMedications(),
                                                            mapperMRR.getAllergies()
                                                    )
                                            ).toList()
                            );
                        }
                )
                .collect(Collectors.toList());


        return new PersonsFireStationDTO(fireStation.get().getStation(), personList);
    }
}
