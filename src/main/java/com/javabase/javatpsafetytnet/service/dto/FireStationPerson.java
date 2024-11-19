package com.javabase.javatpsafetytnet.service.dto;

public class FireStationPerson {

    private String firestation;
    private
    private double personMajor;
    private double personMinor;

    public FireStationPerson(String firestation, double personMajor, double personMinor) {
        this.firestation = firestation;
        this.personMajor = personMajor;
        this.personMinor = personMinor;
    }

    // Getter

    public String getFirestation() {
        return firestation;
    }

    public double getPersonMajor() {
        return personMajor;
    }

    public double getPersonMinor() {
        return personMinor;
    }

    // Setter

    public void setFirestation(String firestation) {
        this.firestation = firestation;
    }

    public void setPersonMajor(double personMajor) {
        this.personMajor = personMajor;
    }

    public void setPersonMinor(double personMinor) {
        this.personMinor = personMinor;
    }
}
