package com.Transylvania.Hotel_Transylvania.service;

import com.Transylvania.Hotel_Transylvania.entity.Order;
import com.Transylvania.Hotel_Transylvania.entity.OrderStatus;
import com.Transylvania.Hotel_Transylvania.entity.User;
import com.Transylvania.Hotel_Transylvania.repository.OrderRepository;
import com.Transylvania.Hotel_Transylvania.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(String userId, double amount) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order(user, amount);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(String orderId, OrderStatus status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);

        return orderRepository.save(order);
    }
}