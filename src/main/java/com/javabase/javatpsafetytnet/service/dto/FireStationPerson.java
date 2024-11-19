package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class FireStationPerson {

    private String firestation;

    private List<PersonContact> personContactList;

    private long personMajor;
    private long personMinor;

    public FireStationPerson(String firestation, List<PersonContact> personContactList, long personMajor, long personMinor) {
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

    public long getPersonMajor() {
        return personMajor;
    }

    public long getPersonMinor() {
        return personMinor;
    }

    // Setter

    public void setPersonContactList(List<PersonContact> personContactList) {
        this.personContactList = personContactList;
    }

    public void setFirestation(String firestation) {
        this.firestation = firestation;
    }

    public void setPersonMajor(long personMajor) {
        this.personMajor = personMajor;
    }

    public void setPersonMinor(long personMinor) {
        this.personMinor = personMinor;
    }
}
