package com.example.jwtdemo.controllers;

import com.example.jwtdemo.entities.Order;
import com.example.jwtdemo.repositories.OrderItemRepository;
import com.example.jwtdemo.repositories.OrderRepository;
import com.example.jwtdemo.responses.OrderCreatedResponse;
import com.example.jwtdemo.responses.OrderListResponse;
import com.example.jwtdemo.responses.ProductListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders_list")
    public OrderListResponse getAllOrders(){
        return new OrderListResponse("Orders List Fetched SuccessFully",orderRepository.findAll());
    }

    @PostMapping("/add_order")
    public ResponseEntity<OrderCreatedResponse> createOrder(@RequestBody Order order){
        Order createdOrder = orderRepository.save(order);
        OrderCreatedResponse response = new OrderCreatedResponse("Order Placed SuccessFully..",createdOrder);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/order_details/{id}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int id,@RequestBody Order order){
        Optional<Order> placedOrder = orderRepository.findById(id);
        if(placedOrder.isPresent()){
            return new ResponseEntity<Order>(placedOrder.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Order(),HttpStatus.NOT_FOUND);
        }
    }



}
