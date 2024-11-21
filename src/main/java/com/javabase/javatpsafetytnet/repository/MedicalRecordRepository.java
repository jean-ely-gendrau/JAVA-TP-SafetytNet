package com.javabase.javatpsafetytnet.repository;

import com.javabase.javatpsafetytnet.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class MedicalRecordRepository {

    /**
     * Wired Repositories
     */
    private final DataRepository dataRepository;

    /**
     * Contructor
     * Wired repositories
     *
     * @param dataRepository
     */
    public MedicalRecordRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    /**
     * findAll
     *
     * @return List MedicalRecord
     */
    public List<MedicalRecord> findAll() {
        return dataRepository
                .findAllMedicalRecord();
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
