package com.microservices.orderservice.repository;

import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.OrderLineItems;

import java.util.List;

public interface OrderRepository {
    void saveOrder(Order order);
    void placeOrder(List<OrderLineItems> orderLineItemsList, Integer orderId);
    Integer lastInsertId();
}
