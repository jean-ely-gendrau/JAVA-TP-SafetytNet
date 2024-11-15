package com.javabase.javatpsafetytnet.model;

import java.util.List;

public class Data {

    private List<Personne> personnes;
    private List<Firestation> firestations;
    private List<Medicalrecord> medicalrecords;

    public Data() {
    }


    public Data(List<Personne> personnes, List<Firestation> firestations, List<Medicalrecord> medicalrecords) {
        this.personnes = personnes;
        this.firestations = firestations;
        this.medicalrecords = medicalrecords;
    }

    // Getter


    public List<Personne> getPersonnes() {
        return personnes;
    }

    public List<Firestation> getFirestations() {
        return firestations;
    }

    public List<Medicalrecord> getMedicalrecords() {
        return medicalrecords;
    }

    // Setter


    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public void setFirestations(List<Firestation> firestations) {
        this.firestations = firestations;
    }

    public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }
}
