package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class MedicalHistoryDTO {

    List<String> medications;
    List<String> allergies;

    public MedicalHistoryDTO(List<String> medications, List<String> allergies) {
        this.medications = medications;
        this.allergies = allergies;
    }

    // Getter

    public List<String> getMedications() {
        return medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    // Setter

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}
