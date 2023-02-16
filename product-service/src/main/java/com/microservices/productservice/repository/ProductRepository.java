package com.microservices.productservice.repository;

import com.microservices.productservice.model.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);

    List<Product> getAll();
}
