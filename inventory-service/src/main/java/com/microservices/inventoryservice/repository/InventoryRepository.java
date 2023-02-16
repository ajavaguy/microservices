package com.microservices.inventoryservice.repository;

public interface InventoryRepository {
    boolean isInStock(String skuCode);
}
