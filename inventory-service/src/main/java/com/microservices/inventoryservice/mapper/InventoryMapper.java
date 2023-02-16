package com.microservices.inventoryservice.mapper;

import com.microservices.inventoryservice.model.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface InventoryMapper {
    Optional<Inventory> findBy(@Param("skuCode") String skuCode);
}
