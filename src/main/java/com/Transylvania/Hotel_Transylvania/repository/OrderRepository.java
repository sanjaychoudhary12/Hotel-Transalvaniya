package com.Transylvania.Hotel_Transylvania.repository;

import com.Transylvania.Hotel_Transylvania.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}