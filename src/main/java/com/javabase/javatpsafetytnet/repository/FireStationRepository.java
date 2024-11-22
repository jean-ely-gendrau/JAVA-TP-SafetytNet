package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FireStationRepository {

    /**
     * Wired Repository
     */
    private final DataRepository dataRepository;

    /**
     * Constructor
     * Wired repositories
     * @param dataRepository
     */
    public FireStationRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * findAll
     *
     * @return
     */
    public List<FireStation> findAll(){
        return dataRepository
                .getData().getFirestations();
    }

    /**
     * findByStation
     *
     * @param stationNumber
     * @return List String
     */
    public List<String> findByStation(String stationNumber){
        return dataRepository
                .findAllFireStation()
                .stream()
                .filter(station -> Objects.equals(station.getStation(), stationNumber))
                .map(FireStation::getAddress)
                .toList();

    }

    /**
     * findByAddress
     *
     * @param address
     * @return Optional FireStation
     */
    public Optional<FireStation> findByAddress(String address){
    return dataRepository
            .findAllFireStation()
            .stream()
            .filter(fireStation -> Objects.equals(fireStation.getAddress(), address))
            .findFirst();
    }

    /**
     * findAllByListStationNumber
     *
     * @param stationsNumber
     * @return List FireStation
     */
    public List<FireStation> findAllByListStationNumber(List<String> stationsNumber){
        return dataRepository
                .findAllFireStation()
                .stream()
                .filter(station -> stationsNumber.contains(station.getStation()))
                .collect(Collectors.toList());
    }

    /**
     * findAllByStationNumber
     * @param stationsNumber
     * @return List FireStation
     */
    public List<FireStation> findAllByStationNumber(String stationsNumber){
        return dataRepository
                .findAllFireStation()
                .stream()
                .filter(station -> stationsNumber.contains(station.getStation()))
                .collect(Collectors.toList());
    }
}
