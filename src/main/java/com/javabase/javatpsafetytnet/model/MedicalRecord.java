package com.javabase.javatpsafetytnet.model;

import java.util.List;

public class MedicalRecord {

    private String firstName;
    private String lastName;
    private String birthdate;

    List<String> medications;
    List<String> allergies;

    public MedicalRecord() {
    }

    public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName +
                "', lastName='" + lastName +
                "', birthdate='" + birthdate +
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

    public String getbirthdate() {
        return birthdate;
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

    public void setbirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}
