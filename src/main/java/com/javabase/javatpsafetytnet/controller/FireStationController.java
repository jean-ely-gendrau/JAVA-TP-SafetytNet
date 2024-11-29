package com.javabase.javatpsafetytnet.controller;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.Person;
import com.javabase.javatpsafetytnet.service.FireStationService;
import com.javabase.javatpsafetytnet.service.dto.FireStationPersonDTO;
import com.javabase.javatpsafetytnet.service.dto.PersonsByStationDTO;
import org.springframework.web.bind.annotation.*;

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

    /* CRUD */

    /**
     * addNewFirestation
     *
     * @param firestation
     * @return Firestation
     * @throws Exception
     */
    @PostMapping("/addFirestation")
    public Person addNewFirestation(
            @RequestBody FireStation firestation
    ) throws Exception {

        return fireStationService.addFirestation(firestation);

    }

    /**
     * updateFirestation
     *
     * @param firestation
     * @return Firestation
     * @throws Exception
     */
    @PutMapping("/updateFirestation")
    public Person updateFirestation(
            @RequestBody FireStation firestation
    ) throws Exception {

        return  fireStationService.updateFirestation(firestation);

    }

    /**
     * deleteFirestation
     *
     * @param stationNumber
     * @param address
     * @return String
     * @throws Exception
     */
    @DeleteMapping("/deleteFirestation")
    public String deleteFirestation(@RequestParam String stationNumber,
                               @RequestParam String address
    ) throws Exception {

        return fireStationService.deleteFirestation(stationNumber, address);

    }

}
