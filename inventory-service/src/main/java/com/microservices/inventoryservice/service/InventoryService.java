package com.microservices.inventoryservice.service;

import com.microservices.inventoryservice.dto.InventoryResponse;
import com.microservices.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isOutOfStock(List<Integer> productIds) {
        return inventoryRepository.findByProductIdIn(productIds)
                .stream()
                .map(inventory -> InventoryResponse.builder()
                        .productId(inventory.getProductId())
                        .isOutOfStock(inventory.getQuantity() == 0)
                        .build())
                .collect(Collectors.toList());
    }
}
