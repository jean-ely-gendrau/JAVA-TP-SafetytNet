package com.javabase.javatpsafetytnet.service.dto;

import com.javabase.javatpsafetytnet.model.Person;

import java.util.List;

public class ChildAlertDTO {

    private String firstName;
    private String lastName;
    private Double age;

    List<Person> familyMembers;

    public ChildAlertDTO() {
    }

    public ChildAlertDTO(String firstName, String lastName, Double age, List<Person> familyMembers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.familyMembers = familyMembers;
    }

    // Getter

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getAge() {
        return age;
    }

    public List<Person> getFamilyMembers() {
        return familyMembers;
    }

    // Setter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public void setFamilyMembers(List<Person> familyMembers) {
        this.familyMembers = familyMembers;
    }
}
