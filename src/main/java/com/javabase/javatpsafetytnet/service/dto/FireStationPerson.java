package com.javabase.javatpsafetytnet.service.dto;

public class FireStationPerson {

    private String fistName;
    private String lastName;
    private String address;
    private String phone;

    private double personMajor;
    private double personMinor;

    public FireStationPerson(String fistName, String lastName, String address, String phone, double personMajor, double personMinor) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.personMajor = personMajor;
        this.personMinor = personMinor;
    }

    // Getter

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public double getPersonMajor() {
        return personMajor;
    }

    public double getPersonMinor() {
        return personMinor;
    }

    // Setter


    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPersonMajor(double personMajor) {
        this.personMajor = personMajor;
    }

    public void setPersonMinor(double personMinor) {
        this.personMinor = personMinor;
    }
}
