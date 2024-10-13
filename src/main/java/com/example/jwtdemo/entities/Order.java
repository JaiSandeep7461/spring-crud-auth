package com.example.jwtdemo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "total_price",nullable = false)
    private double totalPrice;

    @Column(nullable = false)
    private String status;

    @Column(name = "created_at")
    private String createdAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order(User user, double totalPrice, String status, String createdAt, List<OrderItem> orderItems) {
        this.user = user;
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.orderItems = orderItems;
    }

    public Order(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}