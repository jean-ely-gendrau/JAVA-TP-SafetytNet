package com.javabase.javatpsafetytnet.model;

public class FireStation {

    private String address;
    private String station;

    /**
     * Constructor with non
     */
    public FireStation() {
    }

    /**
     * Constructor with injected properties
     *
     * @param address
     * @param station
     */
    public FireStation(String address, String station) {
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
