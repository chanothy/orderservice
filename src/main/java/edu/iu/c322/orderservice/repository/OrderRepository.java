package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.ShippingAddress;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public List<Order> findAll() {
        return orders;
    }
    public int create(Order order) {
        int id = orders.size() + 1;
        order.setCustomerId(id);
        orders.add(order);
        return id;
    }
}
