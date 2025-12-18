package com.astik.microservices.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventry",url = "http://localhost:8082")
public interface InventryClient {
    @RequestMapping(method = RequestMethod.GET ,value="/api/inventry")
    public boolean isInStock(@RequestParam String skuCode,@RequestParam int quantity);
}
