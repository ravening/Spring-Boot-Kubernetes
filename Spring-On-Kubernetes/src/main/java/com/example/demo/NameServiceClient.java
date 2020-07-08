package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "k8s-workshop-name-service")
public interface NameServiceClient {
    @GetMapping
    public String  getName();
}
