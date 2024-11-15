package com.javabase.javatpsafetytnet.model;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;

import java.net.URL;
import java.util.List;

public class Data {

    private List<Personne> personnes;
    private List<Firestation> firestations;
    private List<MedicalRecord> medicalRecords;

    public Data() {
    }


    public Data(List<Personne> personnes, List<Firestation> firestations, List<MedicalRecord> medicalRecords) {
        this.personnes = personnes;
        this.firestations = firestations;
        this.medicalRecords = medicalRecords;
    }

    // Static
    public static <T> T get(URL url, Class<T> type) {
        Jackson2ObjectMapperBuilderCustomizer mapper = new ObjectMapper();
        return mapper.readValue(url, type);
    }

    // Getter

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public List<Firestation> getFirestations() {
        return firestations;
    }

    public List<MedicalRecord> getMedicalrecords() {
        return medicalRecords;
    }

    // Setter


    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public void setFirestations(List<Firestation> firestations) {
        this.firestations = firestations;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
