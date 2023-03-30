package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.CancelledOrder;
import edu.iu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CancelledOrderRepository {
    private List<CancelledOrder> cancelledOrders = new ArrayList<>();

    public List<CancelledOrder> findAll() {
        return cancelledOrders;
    }
    public int create(CancelledOrder cancelledOrder) {
        cancelledOrders.add(cancelledOrder);
        return cancelledOrder.getOrderId();
    }


}
