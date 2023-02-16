package com.microservices.orderservice.mapper;

import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.OrderLineItems;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    void placeOrder(@Param("orderLineItemsList") List<OrderLineItems> orderLineItemsList, @Param("orderId") Integer orderId);

    void saveOrder(@Param("order") Order order);

    Integer lastInsertId();
}
