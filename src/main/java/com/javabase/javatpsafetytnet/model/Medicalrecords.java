package com.javabase.javatpsafetytnet.model;

import java.util.ArrayList;
import java.util.List;

public class Medicalrecords {

    List<Medicalrecord> medicalrecords = new ArrayList<Medicalrecord>();

    public Medicalrecords() {
    }

    public Medicalrecords(List<Medicalrecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    // Getter

    public List<Medicalrecord> getMedicalrecords() {
        return medicalrecords;
    }

    // Setter


    public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }
}
