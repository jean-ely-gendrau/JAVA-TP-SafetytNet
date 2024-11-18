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

    public List<String> findByStation(String stationNumber){
        List<String> stationAddress = dataRepository
                .getData()
                .getFirestations()
                .stream()
                .filter(station -> Objects.equals(station.getStation(), stationNumber))
                .map(FireStation::getAddress)
                .toList();

        return dataRepository
                .getData()
                .getPersons()
                .stream()
                .filter(persone-> stationAddress.contains(persone.getAddress()))
                .map(Person::getPhone)
                .distinct()
                .collect(Collectors.toList());

    }
}
