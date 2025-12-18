package com.astik.microservice.inventry.service;

import com.astik.microservice.inventry.repository.InventryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventryService {
    private final InventryRepository inventryRepository;

    public boolean isInStock(String skuCode,int quantity)
    {
        return inventryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }
}
