package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class PersonContactMedicalHistoryDTO {

    private String lastName;
    private String phone;
    private String age;

    private List<MedicalHistoryDTO> medicalHistoryList;

    /**
     * Constructor
     *
     * @param lastName
     * @param phone
     * @param age
     * @param medicalHistoryList
     */
    public PersonContactMedicalHistoryDTO(String lastName, String phone, String age, List<MedicalHistoryDTO> medicalHistoryList) {
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.medicalHistoryList = medicalHistoryList;
    }

    // Getter

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setMedicalHistoryList(List<MedicalHistoryDTO> medicalHistoryList) {
        this.medicalHistoryList = medicalHistoryList;
    }
}
