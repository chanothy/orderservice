package edu.iu.c322.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int customerId;
    private double total;
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ReturnRequest> returns = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Address shippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ReturnRequest> getReturns() {
        return returns;
    }

    public void setReturns(List<ReturnRequest> returns) {
        this.returns = returns;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && customerId == order.customerId && Double.compare(order.total, total) == 0 && shippingAddress.equals(order.shippingAddress) && items.equals(order.items) && payment.equals(order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, total, shippingAddress, items, payment);
    }
}
