package com.astik.microservices.order.controller;

import com.astik.microservices.order.dto.OrderResponse;
import com.astik.microservices.order.repository.OrderRepository;
import com.astik.microservices.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<OrderResponse>placeOrder(RequestMapping OrderRequest order)
    {
        OrderResponse response=orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
