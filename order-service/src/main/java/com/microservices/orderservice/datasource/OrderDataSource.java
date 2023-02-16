package com.microservices.orderservice.datasource;

import com.microservices.orderservice.mapper.OrderMapper;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.OrderLineItems;
import com.microservices.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDataSource implements OrderRepository {

    private final OrderMapper orderMapper;

    @Override
    public void saveOrder(Order order) {
        orderMapper.saveOrder(order);
    }

    @Override
    public void placeOrder(List<OrderLineItems> orderLineItemsList, Integer orderId) {
        orderMapper.placeOrder(orderLineItemsList, orderId);
    }

    @Override
    public Integer lastInsertId() {
        return orderMapper.lastInsertId();
    }
}
