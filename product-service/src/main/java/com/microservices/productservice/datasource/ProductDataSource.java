package com.microservices.productservice.datasource;

import com.microservices.productservice.mapper.ProductMapper;
import com.microservices.productservice.model.Product;
import com.microservices.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDataSource implements ProductRepository {

    private final ProductMapper productMapper;

    @Override
    public void save(Product product) {
        productMapper.createProduct(product);
    }

    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }
}
