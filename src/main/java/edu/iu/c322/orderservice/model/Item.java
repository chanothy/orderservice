package edu.iu.c322.orderservice.model;

import java.util.Objects;

public class Item {
    private String name;
    private int quantity;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && price == item.price && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, price);
    }
}
