package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import com.javabase.javatpsafetytnet.repository.PersonRepository;
import com.javabase.javatpsafetytnet.service.dto.PersonsFireStationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FireStationService {

    /**
     * Wired Repositories
     */
    private final FireStationRepository fireStationRepository;
    private final PersonRepository personRepository;

    /**
     * Constructor
     * Wire Repositories
     *
     * @param fireStationRepository
     * @param personRepository
     */
    public FireStationService(FireStationRepository fireStationRepository, PersonRepository personRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
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
    List<Person> personList = personRepository.findAllByAddress(address);


   }
}
