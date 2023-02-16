package com.microservices.inventoryservice.datasource;

import com.microservices.inventoryservice.mapper.InventoryMapper;
import com.microservices.inventoryservice.model.Inventory;
import com.microservices.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InventoryDataSource implements InventoryRepository {

    private final InventoryMapper inventoryMapper;

    @Override
    public boolean isInStock(String skuCode) {
        Optional<Inventory> inventoryOptional = inventoryMapper.findBy(skuCode);
        return inventoryOptional.isPresent();
    }
}
