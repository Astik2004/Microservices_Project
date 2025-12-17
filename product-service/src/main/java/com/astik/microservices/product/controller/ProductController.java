package com.astik.microservices.product.controller;

import com.astik.microservices.product.dto.ProductRequest;
import com.astik.microservices.product.dto.ProductResponse;
import com.astik.microservices.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse>createProduct(@RequestBody ProductRequest request)
    {
        ProductResponse response=productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>>getAllProduct()
    {
        List<ProductResponse>products=productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
