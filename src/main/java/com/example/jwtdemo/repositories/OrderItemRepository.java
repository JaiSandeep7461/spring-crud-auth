package com.example.jwtdemo.repositories;

import com.example.jwtdemo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Order,Integer> {
}
