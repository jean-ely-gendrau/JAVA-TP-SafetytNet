package com.javabase.javatpsafetytnet.service.dto;

public class PersonContact {

    private String fistName;
    private String lastName;
    private String address;
    private String phone;

    public PersonContact(String fistName, String lastName, String address, String phone) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
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
}
