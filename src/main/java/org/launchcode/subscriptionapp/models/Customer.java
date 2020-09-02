package org.launchcode.subscriptionapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Please enter first name.")
    private String firstName;

    @NotBlank(message = "Please enter last name.")
    private String lastName;

    @NotBlank(message = "Please enter street address.")
    private String streetAddress;

    @NotBlank(message = "Please enter city.")
    private String city;

    private String state;

    private int zip;

    @NotBlank(message = "Please enter email address.")
    @Email
    private String email;

    @NotBlank(message = "Please enter phone number.")
    private String phone;

    private Integer subscriptionLength;

    public Customer(String firstName, String lastName, String streetAddress, String city, String state, int zip, String email, String phone, Integer subscriptionLength) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
        this.subscriptionLength = subscriptionLength;
    }

    public Customer () {}

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSubscriptionLength() {
        return subscriptionLength;
    }

    public void setSubscriptionLength(Integer subscriptionLength) {
        this.subscriptionLength = subscriptionLength;
    }

    @Override
    public String toString() {
        return lastName;
    }

}
