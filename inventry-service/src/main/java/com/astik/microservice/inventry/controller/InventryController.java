package com.astik.microservice.inventry.controller;

import com.astik.microservice.inventry.service.InventryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventry")
@AllArgsConstructor
public class InventryController {
    private final InventryService inventryService;

    @GetMapping
    public ResponseEntity<String>isInStock(@RequestParam String skuCode,@RequestParam int quantity)
    {
        boolean inStock = inventryService.isInStock(skuCode, quantity);

        if (!inStock) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Product not available in required quantity");
        }

        return ResponseEntity
                .ok("Product is in stock");
    }
}
