package com.example.jwtdemo.responses;

import com.example.jwtdemo.entities.Order;

import java.util.List;

public class OrderListResponse {

    private String message;
    private List<Order> orderList;

    public OrderListResponse(String message, List<Order> orderList) {
        this.message = message;
        this.orderList = orderList;
    }

    public OrderListResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
