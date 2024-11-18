package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.service.FireStationService;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<PersonFireAlertDTO> fireAlert(@RequestParam(name = "address") String address){
        return fireStationService.getAllPersonsByAddress(address);
    }

}
