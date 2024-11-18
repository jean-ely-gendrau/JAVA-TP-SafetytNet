package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class FireStationRepository {

    private final DataRepository dataRepository;

    public FireStationRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<FireStation> findAll(){
        return dataRepository
                .findAllFireStation();
    }

    public List<String> findByStation(String stationNumber){
        return dataRepository
                .findAllFireStation()
                .stream()
                .filter(station -> Objects.equals(station.getStation(), stationNumber))
                .map(FireStation::getAddress)
                .toList();

    }

    public List<String> findAllByAddress(String address){
        return dataRepository
                .findAllFireStation()
                .stream()
                .filter(station -> Objects.equals(station.getAddress(), address))
                .map(FireStation::getStation)
                .toList();
    }
}
