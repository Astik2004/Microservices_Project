package com.astik.microservices.order.service;

import com.astik.microservices.order.dto.OrderRequest;
import com.astik.microservices.order.dto.OrderResponse;
import com.astik.microservices.order.entity.Order;
import com.astik.microservices.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest request)
    {
        Order order=Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .skuCode(request.getSkuCode())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .build();
        Order savedOrder=orderRepository.save(order);
        return mapToOrderResponse(savedOrder);
    }

    private OrderResponse mapToOrderResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .skuCode(order.getSkuCode())
                .price(order.getPrice())
                .quantity(order.getQuantity())
                .build();
    }
}
