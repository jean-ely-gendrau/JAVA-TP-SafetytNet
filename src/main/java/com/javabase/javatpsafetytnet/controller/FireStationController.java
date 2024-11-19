package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.service.FireStationService;
import com.javabase.javatpsafetytnet.service.dto.FireStationPerson;
import com.javabase.javatpsafetytnet.service.dto.PersonsByStationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FireStationController {

    private final FireStationService fireStationService;

    public FireStationController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;
    }

    @GetMapping("/phoneAlert")
    public List<String> phoneAlert(@RequestParam(name = "firestation") String stationNumber){
        return fireStationService.getNumberPhoneByStation(stationNumber);
    }

    @GetMapping("/fire")
    public PersonsByStationDTO fireAlert(@RequestParam(name = "address") String address){
        return fireStationService.getAllPersonsByAddress(address);
    }

    @GetMapping("/flood/stations")
    public List<PersonsByStationDTO> floodStation(@RequestParam(name = "stations") List<String> stationsNumber){
        return fireStationService.getAllPersonsByStations(stationsNumber);
    }

    @GetMapping("/firestation")
    public List<FireStationPerson> firestation(@RequestParam(name = "stationNumber") String stationNumber{
        return fireStationService.getAllPersonsByStation(stationNumber);
    }

}
