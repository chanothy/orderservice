package edu.iu.c322.orderservice.model;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String method;
    private int number;

    @OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
