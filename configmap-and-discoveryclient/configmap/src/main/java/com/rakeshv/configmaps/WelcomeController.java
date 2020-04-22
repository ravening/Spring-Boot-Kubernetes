package com.rakeshv.configmaps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/welcome")
@Slf4j
public class WelcomeController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${message:Welcome hello world}")
    private String message;
    @GetMapping
    public String welcome() {
        log.info("{}", message);
        return message;
    }

    @GetMapping("/users")
    public String getUsers() {
        String url = "http://users-service:8080/users";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        log.info("Fetching users: {}", responseEntity.getBody());

        return responseEntity.getBody();
    }
}
