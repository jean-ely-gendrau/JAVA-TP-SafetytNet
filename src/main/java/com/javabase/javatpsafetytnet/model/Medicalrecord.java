package com.javabase.javatpsafetytnet.model;

import java.util.List;

public class Medicalrecord {

    private String firstName;
    private String lastName;
    private String birthday;

    List<String> medications;
    List<String> allergies;

    public Medicalrecord() {
    }

    public Medicalrecord(String firstName, String lastName, String birthday, List<String> medications, List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.medications = medications;
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "firstName='" + firstName +
                "', lastName='" + lastName +
                "', birthday='" + birthday +
                "', medications='" + medications +
                "', allergies='" + allergies +
                "'}";
    }
    
    // Getter
    
    public String getFirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}
