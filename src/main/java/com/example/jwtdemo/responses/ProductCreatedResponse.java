package com.example.jwtdemo.responses;

import com.example.jwtdemo.entities.Product;

public class ProductCreatedResponse {

    private String message;
    private Product product;

    public ProductCreatedResponse(){

    }

    public ProductCreatedResponse(String message, Product product) {
        this.message = message;
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
