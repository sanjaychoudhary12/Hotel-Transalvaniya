package com.Transylvania.Hotel_Transylvania.service;

import com.Transylvania.Hotel_Transylvania.entity.Order;
import com.Transylvania.Hotel_Transylvania.entity.OrderStatus;
import com.Transylvania.Hotel_Transylvania.entity.User;
import com.Transylvania.Hotel_Transylvania.repository.OrderRepository;
import com.Transylvania.Hotel_Transylvania.repository.UserRepository;
import org.slf4j.Logger;                    // ✅ correct import
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class); // ✅ moved to top

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(String userId, double amount) {  // ✅ single method, fully implemented
        log.info("Creating order for userId={}, amount={}", userId, amount);
        User user = userRepository.findById(userId)
                .or(() -> userRepository.findByEmail(userId))
                .orElseThrow(() -> {
                    log.warn("User not found for userId={}", userId);
                    return new RuntimeException("User not found");
                });

        Order order = new Order(user, amount);
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(String orderId, OrderStatus status) {
        log.info("Updating order status for orderId={}, status={}", orderId, status);
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> {
                    log.warn("Order not found for orderId={}", orderId);
                    return new RuntimeException("Order not found");
                });

        order.setStatus(status);
        return orderRepository.save(order);
    }
}