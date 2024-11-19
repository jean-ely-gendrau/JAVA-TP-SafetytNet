package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class PersonMedicalHistoryDTO {

    private String lastName;
    private String address;
    private String email;
    private String age;

    private List<MedicalHistoryDTO> medicalHistoryList;

    public PersonMedicalHistoryDTO(String lastName, String address, String email, String age, List<MedicalHistoryDTO> medicalHistoryList) {
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.medicalHistoryList = medicalHistoryList;
    }

    // Getter

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public List<MedicalHistoryDTO> getMedicalHistoryList() {
        return medicalHistoryList;
    }

    // Setter

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMedicalHistoryList(List<MedicalHistoryDTO> medicalHistoryList) {
        this.medicalHistoryList = medicalHistoryList;
    }
}
