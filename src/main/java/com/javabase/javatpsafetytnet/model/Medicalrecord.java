package com.javabase.javatpsafetytnet.model;

import java.util.List;

public class Medicalrecord {

    private String firstName;
    private String lastname;
    private String birthday;

    List<String> medications;
    List<String> allergies;

    public Medicalrecord() {
    }

    public Medicalrecord(String firstName, String lastname, String birthday, List<String> medications, List<String> allergies) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.birthday = birthday;
        this.medications = medications;
        this.allergies = allergies;
    }

    // Getter


    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getMedications() {
        return medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    // Setter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
