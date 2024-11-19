package com.javabase.javatpsafetytnet.model;

import java.util.List;


public class Data {

    private List<Person> persons;
    private List<FireStation> firestations;
    private List<MedicalRecord> medicalrecords;

    /**
     * Constructor with none
     */
    public Data() {
    }

    /**
     * Constructor With Injected properties
     *
     * @param persons
     * @param firestations
     * @param medicalrecords
     */
    public Data(List<Person> persons, List<FireStation> firestations, List<MedicalRecord> medicalrecords) {
        this.persons = persons;
        this.firestations = firestations;
        this.medicalrecords = medicalrecords;
    }

    // Getter

    public List<Person> getPersons() {
        return persons;
    }

    public List<FireStation> getFirestations() {
        return firestations;
    }

    public List<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }

    // Setter


    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setFirestations(List<FireStation> firestations) {
        this.firestations = firestations;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }
}
