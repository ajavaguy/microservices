package com.microservices.inventoryservice.mapper;

import com.microservices.inventoryservice.model.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InventoryMapper {
    List<Inventory> findByProductIdIn(@Param("productIds") List<Integer> productIds);
}
