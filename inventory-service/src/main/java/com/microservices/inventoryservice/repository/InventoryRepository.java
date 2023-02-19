package com.microservices.inventoryservice.repository;

import com.microservices.inventoryservice.model.Inventory;

import java.util.List;

public interface InventoryRepository {
    List<Inventory> findByProductIdIn(List<Integer> skuCodes);
}
