package com.astik.microservice.inventry.controller;

import com.astik.microservice.inventry.service.InventryService;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<Boolean>isInStock(@RequestParam String skuCode,@RequestParam int quantity)
    {
        return ResponseEntity.ok(
                inventryService.isInStock(skuCode, quantity)
        );
    }
}
