package com.microservices.orderservice.service;

import com.microservices.orderservice.dto.InventoryResponse;
import com.microservices.orderservice.dto.OrderLineItemsRequest;
import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.exception.OutOfStockException;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.OrderLineItems;
import com.microservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsRequests()
                .stream()
                .map(this::mapOrder)
                .collect(Collectors.toList());


        order.setOrderLineItemList(orderLineItemsList); 

        List<Long> productIds = order.getOrderLineItemList()
                .stream()
                .map(OrderLineItems::getProductId)
                .collect(Collectors.toList());

        List<InventoryResponse> inventoryResponses = List.of(webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("productIds", productIds).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block());

        if(inventoryResponses.stream().anyMatch(InventoryResponse::isOutOfStock)) {
            throw new OutOfStockException();
        }

        orderRepository.saveOrder(order);
        Integer orderId = orderRepository.lastInsertId();
        orderRepository.placeOrder(orderLineItemsList, orderId);
    }

    private OrderLineItems mapOrder(OrderLineItemsRequest orderLineItemsRequest) {
        return OrderLineItems.builder()
                .price(orderLineItemsRequest.getPrice())
                .quantity(orderLineItemsRequest.getQuantity())
                .productId(orderLineItemsRequest.getProductId())
                .build();
    }
}
