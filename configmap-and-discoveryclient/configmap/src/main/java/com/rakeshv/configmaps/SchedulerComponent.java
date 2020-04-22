package com.rakeshv.configmaps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SchedulerComponent {

    @Autowired
    WelcomeConfiguration configuration;
    @Autowired
    RestTemplate restTemplate;

    @Scheduled(fixedRate = 5000)
    public void schedule() {
        log.info("Config message is : {}", configuration.getMessage());

        String url = "http://users-service:8080/users";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        log.info("Calling via discovery client.... {}", responseEntity.getBody());
    }
}
