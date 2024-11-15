package com.javabase.javatpsafetytnet.model;

import java.util.List;

public class Firestations {

    List<Firestation> firestations;

    public Firestations() {
    }

    public Firestations(List<Firestation> firestations) {
        this.firestations = firestations;
    }

    // Getter

    public List<Firestation> getFirestations() {
        return firestations;
    }

    // Setter

    public void setFirestations(List<Firestation> firestations) {
        this.firestations = firestations;
    }
}
