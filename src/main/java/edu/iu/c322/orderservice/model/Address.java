package edu.iu.c322.orderservice.model;

import jakarta.validation.constraints.NotEmpty;

public class Address {

    @NotEmpty(message = "state cannot be empty")
    private String state;
    @NotEmpty(message = "city cannot be empty")
    private String city;
    private int postalCode;



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
