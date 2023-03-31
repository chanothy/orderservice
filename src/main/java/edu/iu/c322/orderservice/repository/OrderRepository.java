package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.ReturnRequest;
import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
//    private List<CancelledOrder> cancelledOrders = new ArrayList<>();


    public List<Order> findAll() {
        return orders;
    }
    public int create(Order order) {
        int id = orders.size() + 1;
        order.setOrderId(id);
        orders.add(order);
        order.setStatus("ordered");

        List<Item> items = order.getItems();
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setItemId(i+1);
        }
        return order.getCustomerId();
    }

    public Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }

    public Item getItemById(int id, Order o) {
        return o.getItems().stream().filter(x -> x.getItemId() == id).findAny().orElse(null);
    }

    public void delete(int id) {
        Order x = getOrderById(id);
        if (x != null) {
            x.setStatus("cancelled");
        }
        else {
            throw new IllegalStateException("Order id is not valid");
        }
    }


//    public List<CancelledOrder> findAllCanceled() {
//        return cancelledOrders;
//    }

//    public void update(CancelledOrder order) {
//        CancelledOrder x = getCancelledOrderById(order.getOrderId());
//        if (x != null) {
//            x.setItemId(order.getItemId());
//            x.setReason(order.getReason());
//        }
//        else {
//            throw new IllegalStateException("order id is not valid");
//        }
//    }

    @PutMapping("/return")
    public void update(ReturnRequest cancel) {
        Order x = getOrderById(cancel.getOrderId());
        if (x != null) {
            Item i = getItemById(cancel.getItemId(),x);
            if (i != null) {
                x.getReturns().add((cancel));
            }
            else {
                throw new IllegalStateException("item id is not valid");
            }
        }
        else {
            throw new IllegalStateException("order id is not valid");
        }
    }
//
//    public int create(CancelledOrder order) {
//        cancelledOrders.add(order);
//        return order.getOrderId();
//    }
//
//    public CancelledOrder getCancelledOrderById(int id) {
//        return cancelledOrders.stream().filter(x -> x.getOrderId() == id).findAny().orElse(null);
//    }
}
