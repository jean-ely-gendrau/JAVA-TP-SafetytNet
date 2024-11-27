package com.javabase.javatpsafetytnet.service.dto;

import java.util.List;

public class FireStationPersonDTO {

    private String firestation;

    private List<PersonContactDTO> personContactList;

    private long personMajor;
    private long personMinor;

    /**
     * Constructor per default
     */
    public FireStationPersonDTO() {

    }

    /**
     * Constructor
     *
     * @param firestation
     * @param personContactList
     * @param personMajor
     * @param personMinor
     */
    public FireStationPersonDTO(String firestation, List<PersonContactDTO> personContactList, long personMajor, long personMinor) {
        this.firestation = firestation;
        this.personContactList = personContactList;
        this.personMajor = personMajor;
        this.personMinor = personMinor;
    }

    // Getter

    public String getFirestation() {
        return firestation;
    }

    public List<PersonContactDTO> getPersonContactList() {
        return personContactList;
    }

    public long getPersonMajor() {
        return personMajor;
    }

    public long getPersonMinor() {
        return personMinor;
    }

    // Setter

    public void setPersonContactList(List<PersonContactDTO> personContactList) {
        this.personContactList = personContactList;
    }

    public void setFirestation(String firestation) {
        this.firestation = firestation;
    }

    public void setPersonMajor(long personMajor) {
        this.personMajor = personMajor;
    }

    public void setPersonMinor(long personMinor) {
        this.personMinor = personMinor;
    }
}
