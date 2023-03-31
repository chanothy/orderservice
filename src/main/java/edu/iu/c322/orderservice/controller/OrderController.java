package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.model.ReturnRequest;
import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Order order) {
//        CancelledOrder cancel = new CancelledOrder(order.getOrderId(),0,"Item not cancelled");
//        repository.create(cancel);
        return repository.create(order);
    }



//
//    @GetMapping("/return")
//    public List<CancelledOrder> findAllCancel() {
//        return repository.findAllCanceled();
//    }

    @GetMapping("/{id}")
    public List<Item> findByCustomerID(@PathVariable int id) {
        return repository.findByCustomerID(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        repository.delete(id);
    }

    @PutMapping("/return")
    public void update(@Valid @RequestBody ReturnRequest returnRequest) {
        repository.update(returnRequest);
    }
}
