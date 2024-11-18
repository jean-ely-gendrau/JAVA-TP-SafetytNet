package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class PersonsFireStationDTO {

    private String firestation;
    private List<PersonFireAlertDTO> personFireAlertList;

    public PersonsFireStationDTO(String firestation, List<PersonFireAlertDTO> personFireAlertList) {
        this.firestation = firestation;
        this.personFireAlertList = personFireAlertList;
    }

    // Getter

    public String getFirestation() {
        return firestation;
    }

    public List<PersonFireAlertDTO> getPersonFireAlertList() {
        return personFireAlertList;
    }

    // Setter

    public void setFirestation(String firestation) {
        this.firestation = firestation;
    }

    public void setPersonFireAlertList(List<PersonFireAlertDTO> personFireAlertList) {
        this.personFireAlertList = personFireAlertList;
    }
}
