package iotbay.model;

import java.io.Serializable;

public class Address implements Serializable {
    private int addressID;
    private int userAccountID;
    private String unit;
    private String street;
    private String suburb;
    private String state;
//    Added country
    private String country;
    private String postcode;

    public Address() {
    }

    public Address(
            String unit,
            String street,
            String suburb,
            String state,
            String country,
            String postcode
    ) {
        this.unit = unit;
        this.street = street;
        this.suburb = suburb;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
    }

    public Address(
            int addressID,
            int userAccountID,
            String unit,
            String street,
            String suburb,
            String state,
            String country,
            String postcode
    ) {
        this.addressID = addressID;
        this.userAccountID = userAccountID;
        this.unit = unit;
        this.street = street;
        this.suburb = suburb;
        this.state = state;
        this.country = country;
        this.postcode = postcode;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
