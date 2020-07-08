package com.rakeshv.configmaps;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "configserver")
public interface UserClient {
    @GetMapping("/users")
    public ResponseEntity<String> getUser();
}
