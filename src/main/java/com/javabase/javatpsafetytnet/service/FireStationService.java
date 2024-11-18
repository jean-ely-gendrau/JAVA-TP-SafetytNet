package com.javabase.javatpsafetytnet.service;

import com.javabase.javatpsafetytnet.repository.FireStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {

    private final FireStationRepository fireStationRepository;

    public FireStationService(FireStationRepository fireStationRepository) {
        this.fireStationRepository = fireStationRepository;
    }

    public List<String> getNumberPhoneByStation(String stationNumber){
       return fireStationRepository.findByStation(stationNumber);
   }
}
