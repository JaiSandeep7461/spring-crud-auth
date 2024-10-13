package com.example.jwtdemo.responses;

import com.example.jwtdemo.entities.Order;

public class OrderCreatedResponse {

    private String message;
    private Order order;

    public OrderCreatedResponse(){

    }

    public OrderCreatedResponse(String message, Order order) {
        this.message = message;
        this.order = order;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
