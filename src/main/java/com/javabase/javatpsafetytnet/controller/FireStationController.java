package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.FireStationService;
import com.javabase.javatpsafetytnet.service.dto.FireStationPersonDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonsByStationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FireStationController {

    /**
     * Wired Services
     */
    private final FireStationService fireStationService;

    /**
     * Constructor
     * Wire services
     *
     * @param fireStationService
     */
    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    /**
     * phoneAlert
     *
     * @param stationNumber
     * @return List String
     */
    @GetMapping("/phoneAlert")
    public List<String> phoneAlert(@RequestParam(name = "firestation") String stationNumber){
        return fireStationService.getNumberPhoneByStation(stationNumber);
    }

    /**
     * fireAlert
     *
     * @param address
     * @return PersonsByStationDTO
     */
    @GetMapping("/fire")
    public PersonsByStationDTO fireAlert(@RequestParam(name = "address") String address){
        return fireStationService.getAllPersonsByAddress(address);
    }

    /**
     * floodStation
     *
     * @param stationsNumber
     * @return List PersonsByStationDTO
     */
    @GetMapping("/flood/stations")
    public List<PersonsByStationDTO> floodStation(@RequestParam(name = "stations") List<String> stationsNumber){
        return fireStationService.getAllPersonsByStations(stationsNumber);
    }

    /**
     * fireStation
     *
     * @param stationNumber
     * @return List FireStationPersonDTO
     */
    @GetMapping("/firestation")
    public List<FireStationPersonDTO> fireStation(@RequestParam(name = "stationNumber") String stationNumber){
        return fireStationService.getAllPersonsByStation(stationNumber);
    }

}
