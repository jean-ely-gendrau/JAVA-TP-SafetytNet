package com.javabase.javatpsafetytnet.model;

public class Firestation {

    private String address;
    private String station;

    public Firestation() {
    }

    public Firestation(String address, String station) {
        this.address = address;
        this.station = station;
    }

    // Getter

    public String getAddress() {
        return address;
    }

    public String getStation() {
        return station;
    }

    // Setter

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
