package com.Transylvania.Hotel_Transylvania.controller;

import com.Transylvania.Hotel_Transylvania.entity.Order;
import com.Transylvania.Hotel_Transylvania.entity.OrderStatus;
import com.Transylvania.Hotel_Transylvania.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(@RequestParam String userId,
                             @RequestParam double amount) {
        return service.createOrder(userId, amount);
    }

    @GetMapping
    public List<Order> getOrders() {
        return service.getAllOrders();
    }

    @PutMapping("/{orderId}/status")
    public Order updateStatus(@PathVariable String orderId,
                              @RequestParam OrderStatus status) {
        return service.updateOrderStatus(orderId, status);
    }
}


