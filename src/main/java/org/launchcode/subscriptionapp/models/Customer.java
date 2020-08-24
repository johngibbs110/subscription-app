package org.launchcode.subscriptionapp.models;

public class Customer {

    private int id;
    private static int nextId = 1;

    private String firstName;
    private String lastName;
    private String streetAddress;

    public Customer(String firstName, String lastName, String streetAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Override
    public String toString() {
        return lastName;
    }

}
