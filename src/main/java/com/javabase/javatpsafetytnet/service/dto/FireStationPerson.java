package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class FireStationPerson {

    private String firestation;

    private List<PersonContact> personContactList;

    private double personMajor;
    private double personMinor;

    public FireStationPerson(String firestation, List<PersonContact> personContactList, double personMajor, double personMinor) {
        this.firestation = firestation;
        this.personContactList = personContactList;
        this.personMajor = personMajor;
        this.personMinor = personMinor;
    }

    // Getter

    public String getFirestation() {
        return firestation;
    }

    public List<PersonContact> getPersonContactList() {
        return personContactList;
    }

    public double getPersonMajor() {
        return personMajor;
    }

    public double getPersonMinor() {
        return personMinor;
    }

    // Setter

    public void setPersonContactList(List<PersonContact> personContactList) {
        this.personContactList = personContactList;
    }

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
