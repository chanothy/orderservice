package edu.iu.c322.orderservice.controller;


import edu.iu.c322.orderservice.model.ReturnRequest;
import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrdRepository;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrdRepository repository;
    public OrderController(OrdRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Order order) {
        Order addedOrder = repository.save(order);
        return addedOrder.getOrderId();
    }



//
//    @GetMapping("/return")
//    public List<CancelledOrder> findAllCancel() {
//        return repository.findAllCanceled();
//    }

    @GetMapping("/{id}")
    public List<Item> findByCustomerID(@PathVariable int id) {
        Order order = repository.getById(id);
        if (order != null) {
            return order.getItems();
        }
        else {
            throw new IllegalStateException("order id is not valid");
        }
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        Order order = entityManager.find(Order.class,id);
////        return repository.findByCustomerID(id);
//        entityManager.close();
//        if (order != null) {
//            return order.getItems();
//        }
//        else {
//            throw new IllegalStateException("order id is not valid");
//        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Order order = new Order();
        order.setOrderId(id);
        repository.delete(order);
    }
//
    @PutMapping("/return")
    public void update(@Valid @RequestBody ReturnRequest returnRequest) {
        Order order = repository.getById(returnRequest.getOrderId());
        order.getReturns().add(returnRequest);
        repository.save(order);
    }
}
