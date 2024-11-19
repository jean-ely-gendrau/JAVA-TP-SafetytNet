package com.javabase.javatpsafetytnet.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;

    /**
     * Constructor
     */
    public Person() {
    }

    /**
     * Constructor with injected properties
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param zip
     * @param phone
     * @param email
     */
    public Person(String firstName, String lastName, String address, String city, String zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName +
                "', lastName='" + lastName +
                "', address='" + address +
                "', city='" + city +
                "', zip='" + zip +
                "', phone='" + phone +
                "', email='" + email +
                "'}";
    }

    // Method

    /**
     * static getAge
     *
     * @param birthdate
     * @return double
     */
    public static double getAge(String birthdate){
        LocalDate localDateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return Period.between(LocalDate.parse(birthdate, formatter), localDateNow).getYears();
    }

    /**
     * isAdult
     *
     * @param birthdate
     * @return boolean
     */
    public static  boolean isAdult(String birthdate){
        LocalDate localDateNow = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return Period.between(LocalDate.parse(birthdate, formatter), localDateNow).getYears() >= 18;
    }

    // Getter

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    // Setter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
