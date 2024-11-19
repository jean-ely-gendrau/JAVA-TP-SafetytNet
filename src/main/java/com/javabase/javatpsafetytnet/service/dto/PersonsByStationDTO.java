package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class PersonsByStationDTO {

    private String firestation;
    private String address;
    private List<PersonContactMedicalHistoryDTO> personFireAlertList;

    public PersonsByStationDTO(String firestation, String address, List<PersonContactMedicalHistoryDTO> personFireAlertList) {
        this.firestation = firestation;
        this.address = address;
        this.personFireAlertList = personFireAlertList;
    }

    // Getter

    public String getFirestation() {
        return firestation;
    }

    public List<PersonContactMedicalHistoryDTO> getPersonFireAlertList() {
        return personFireAlertList;
    }

    public String getAddress() {
        return address;
    }

    // Setter

    public void setFirestation(String firestation) {
        this.firestation = firestation;
    }

    public void setPersonFireAlertList(List<PersonContactMedicalHistoryDTO> personFireAlertList) {
        this.personFireAlertList = personFireAlertList;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
