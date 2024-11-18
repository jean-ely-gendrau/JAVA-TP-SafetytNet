package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.FireStation;
import com.javabase.javatpsafetytnet.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
