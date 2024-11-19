package com.javabase.javatpsafetytnet.model;

import java.util.List;

public class MedicalRecord {

    private String firstName;
    private String lastName;
    private String birthdate;

    List<String> medications;
    List<String> allergies;

    /**
     * Constructor
     */
    public MedicalRecord() {
    }

    /**
     * Constructor with injected properties
     *
     * @param firstName
     * @param lastName
     * @param birthdate
     * @param medications
     * @param allergies
     */
    public MedicalRecord(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
    }

    /**
     * toString
     *
     * @return String
     */
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

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
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

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}
