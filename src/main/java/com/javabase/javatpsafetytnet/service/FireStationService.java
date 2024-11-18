package com.javabase.javatpsafetytnet.service;

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
     * @param stationNumber
     * @return List String
     */
    public List<String> getNumberPhoneByStation(String stationNumber){
        // Find All Station match with stationNumber params
        List<String> stationAddress = fireStationRepository.findByStation(stationNumber);

        // Return all Phone Number match with all stationAddress List
        return personRepository.findAll()
                .stream()
                .filter(persone-> stationAddress.contains(persone.getAddress()))
                .map(Person::getPhone)
                .distinct()
                .collect(Collectors.toList());
   }

    /**
     * getAllPersonsByAddress
     *
     * @param address
     * @return List PersonFireAlertDTO
     */
   public List<PersonsFireStationDTO> getAllPersonsByAddress(String address){
       List<String> fireStation = fireStationRepository.findAllByAddress(address);

        Stream<PersonFireAlertDTO> personList = personRepository.findAllByAddress(address)
                .stream()
                .map(mapper-> new PersonFireAlertDTO(
                        mapper.getLastName(),
                        mapper.getPhone(),
                        medicalRecordRepository.findAllByLastName(mapper.getLastName())
                                .stream()
                                .map(MedicalRecord::getBirthdate)
                                .toString(),
                        medicalRecordRepository.findAllByLastName(mapper.getLastName())
                                .stream()
                                .map(mapperMRR -> new MedicalHistoryDTO(
                                        mapperMRR.getMedications(),
                                        mapperMRR.getAllergies()
                                        )
                                ).toList()
                ));



    return new PersonsFireStationDTO(fireStation, personList);
   }
}
