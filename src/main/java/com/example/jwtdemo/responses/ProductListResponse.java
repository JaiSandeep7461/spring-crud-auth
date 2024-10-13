package com.example.jwtdemo.responses;

import com.example.jwtdemo.entities.Product;

import java.util.List;

public class ProductListResponse {

    private String message;
    private List<Product> productList;

    public ProductListResponse(){

    }

    public ProductListResponse(String message, List<Product> productList) {
        this.message = message;
        this.productList = productList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
