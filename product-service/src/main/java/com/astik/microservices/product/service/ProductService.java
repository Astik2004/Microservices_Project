package com.astik.microservices.product.service;

import com.astik.microservices.product.dto.ProductRequest;
import com.astik.microservices.product.dto.ProductResponse;
import com.astik.microservices.product.entity.Product;
import com.astik.microservices.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest request)
    {
        Product product= Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        Product savedProduct=productRepository.save(product);
        log.info("Product {} saved",savedProduct.getId());
        return mapToProductResponse(savedProduct);
    }

    public List<ProductResponse> getAllProduct() {
        List<Product>products=productRepository.findAll();
        return products.stream().map(product->mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
