package com.microservices.productservice.mapper;

import com.microservices.productservice.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void createProduct(@Param("product") Product product);

    List<Product> getAll();
}
