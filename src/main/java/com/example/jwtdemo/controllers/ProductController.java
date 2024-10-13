package com.example.jwtdemo.controllers;

import com.example.jwtdemo.entities.Product;
import com.example.jwtdemo.repositories.ProductRepository;
import com.example.jwtdemo.responses.ProductCreatedResponse;
import com.example.jwtdemo.responses.ProductListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products_list")
    public ProductListResponse getAllProducts(){
        return new ProductListResponse("List Fetched Successfully",productRepository.findAll());
    }

    @PostMapping("/add_product")
    public ResponseEntity<ProductCreatedResponse> createProduct(@RequestBody Product product){
        Product createdProduct = productRepository.save(product);
        ProductCreatedResponse response = new ProductCreatedResponse("Product has been created Successfully",createdProduct);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update_product/{id}")
    public ResponseEntity<ProductCreatedResponse> updateProduct(@PathVariable int id,@RequestBody Product product){
        Optional<Product> existProd =productRepository.findById(id);
        if(existProd.isPresent()){
            existProd.get().setName(product.getName());
            existProd.get().setDescription(product.getDescription());
            existProd.get().setPrice(product.getPrice());
            existProd.get().setStock(product.getStock());
            existProd.get().setCreatedAt(product.getCreatedAt());
            return new ResponseEntity<>(new ProductCreatedResponse("Product Updated Successfully",productRepository.save(existProd.get())),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(new ProductCreatedResponse("Product not Found", new Product()),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Optional<Product> existProd = productRepository.findById(id);
        if(existProd.isPresent()){
            productRepository.deleteById(id);
            return  new ResponseEntity<>("Product Deleted with id "+id +" Successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }
    }


}
