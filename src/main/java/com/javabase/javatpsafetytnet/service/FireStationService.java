package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.MedicalRecordRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
     * @return PersonContactDTO
     */
    public PersonsByStationDTO getAllPersonsByAddress(String address) {
        Optional<FireStation> fireStation = fireStationRepository.findByAddress(address);

        List<PersonContactDTO> personList = personRepository.findAllByAddress(address)
                .stream()
                .map(mapper -> {
                            String dateString = medicalRecordRepository
                                    .findAllByIdentity(mapper.getLastName(), mapper.getFirstName())
                                    .get(0)
                                    .getBirthdate();

                            return new PersonContactDTO(
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


        return new PersonsByStationDTO(fireStation.get().getStation(), address, personList);
    }

    public List<PersonsByStationDTO> getAllPersonsByStations(List<String> stationsNumber) {
        return fireStationRepository.findAllByListStationNumber(stationsNumber)
                .stream()
                .map(mapper -> new PersonsByStationDTO(
                                mapper.getStation(),
                                mapper.getAddress(),
                                personRepository.findAllByAddress(mapper.getAddress())
                                        .stream()
                                        .map(mapperPerson -> new PersonContactDTO(
                                                        mapperPerson.getLastName(),
                                                        mapperPerson.getPhone(),
                                                        medicalRecordRepository.findAllByIdentity(mapperPerson.getLastName(), mapperPerson.getFirstName())
                                                                .stream()
                                                                .map(MedicalRecord::getBirthdate)
                                                                .toString(),
                                                        medicalRecordRepository.findAllByIdentity(mapperPerson.getLastName(), mapperPerson.getFirstName())
                                                                .stream()
                                                                .map(mapperMedical -> new MedicalHistoryDTO(
                                                                                mapperMedical.getMedications(),
                                                                                mapperMedical.getAllergies()
                                                                        )
                                                                ).collect(Collectors.toList())
                                                )
                                        ).collect(Collectors.toList())
                        )
                ).collect(Collectors.toList());
    }

    /**
     * getAllPersonsByStation
     *
     * @param stationNumber
     * @return
     */
    public List<FireStationPerson> getAllPersonsByStation(String stationNumber){
        return fireStationRepository.findAllByStationNumber(stationNumber)
                .stream()
                .map(m ->))
    }
}
