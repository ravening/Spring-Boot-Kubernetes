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
    @Autowired
    UserClient userClient;

    @Scheduled(fixedRate = 5000)
    public void schedule() {
        log.info("Config message is : {}", configuration.getMessage());

        ResponseEntity<String> responseEntity = userClient.getUser();
        log.info("Calling via discovery client.... {}", responseEntity.getBody());
    }
}
