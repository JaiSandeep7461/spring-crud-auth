package com.example.jwtdemo.repositories;

import com.example.jwtdemo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
