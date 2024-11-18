package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class MedicalRecordRepository {

    private final DataRepository dataRepository;

    public MedicalRecordRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<MedicalRecord> findAll(){
        return dataRepository
                .findAllMedicalRecord();
    }

    /**
     * findAllByLastName
     *
     * @param lastName
     * @return List MedicalRecord
     */
    public List<MedicalRecord> findAllByLastName(String lastName){
        return dataRepository
                .findAllMedicalRecord()
                .stream()
                .filter(medicalRcord -> Objects.equals(medicalRcord.getLastName(), lastName))
                .collect(Collectors.toList());
    }
}
