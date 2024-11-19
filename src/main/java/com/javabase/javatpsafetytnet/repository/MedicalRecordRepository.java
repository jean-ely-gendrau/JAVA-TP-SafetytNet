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

    public List<MedicalRecord> findAll() {
        return dataRepository
                .findAllMedicalRecord();
    }

    /**
     * findAllByLastName
     *
     * @param lastName
     * @return List MedicalRecord
     */
    public List<MedicalRecord> findAllByLastName(String lastName) {
        return dataRepository
                .findAllMedicalRecord()
                .stream()
                .filter(medicalRcord -> Objects.equals(medicalRcord.getLastName(), lastName))
                .collect(Collectors.toList());
    }

    /**
     * findAllByIdentity
     *
     * @param lastName
     * @param firstName
     * @return List MedicalRecord
     */
    public List<MedicalRecord> findAllByIdentity(String lastName, String firstName) {
        return dataRepository
                .findAllMedicalRecord()
                .stream()
                .filter(medicalRecord -> Objects.equals(medicalRecord.getLastName(), lastName))
                .filter(medicalRecord ->Objects.equals(medicalRecord.getFirstName(), firstName))
                .collect(Collectors.toList());
    }

    /**
     * findByIdentity
     *
     * @param lastName
     * @param firstName
     * @return List MedicalRecord
     */
    public List<MedicalRecord> findByIdentity(String lastName, String firstName) {
        return dataRepository
                .findAllMedicalRecord()
                .stream()
                .filter(medicalRecord -> Objects.equals(medicalRecord.getLastName(), lastName))
                .filter(medicalRecord ->Objects.equals(medicalRecord.getFirstName(), firstName))
                .collect(Collectors.toList());
    }
}
