package com.astik.microservice.inventry.repository;

import com.astik.microservice.inventry.entity.Inventry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventryRepository extends JpaRepository<Inventry,Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
