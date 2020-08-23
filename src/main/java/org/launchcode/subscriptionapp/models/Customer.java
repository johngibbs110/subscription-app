package org.launchcode.subscriptionapp.models;

public class Customer {

    private int id;
    private static int nextId = 1;

    private String name;
    private String streetAddress;

    public Customer(String name, String streetAddress) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Override
    public String toString() {
        return name;
    }

}
