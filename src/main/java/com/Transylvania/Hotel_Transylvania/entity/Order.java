package com.Transylvania.Hotel_Transylvania.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String id;

   // private String userId;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", nullable = false)
   private User user;

    private double amount;
    //private String status;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime createdAt;



    public  Order() {}

    public  Order(User user, double amount) {
        this.id = UUID.randomUUID().toString();
        //this.userId = userId;
        // ✅ Constructor now takes User object
        this.user = user;
        this.amount = amount;
        this.status = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    //getter and setter
    public String getId(){ return id;}
   // public String getUserId() { return userId;}
    public  User getUser() { return user;}
    public double getAmount() { return amount;}
    public OrderStatus getStatus() { return status; }
   // public  String getStatus() { return status;}
    public LocalDateTime getCreatedAt(){ return createdAt;}

    public void setStatus(OrderStatus status) {this.status = status;}

}
