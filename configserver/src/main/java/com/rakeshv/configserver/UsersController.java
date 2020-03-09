package com.rakeshv.configserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @GetMapping
    public String getUsers() {
        log.info("Received a request from client@!!!!!!");
        return "Spring, boot, cloud, kubernetes, configmap, discoveryclient";
    }

    @GetMapping("/test")
    public String test() {
        log.info("testing the skaffold");
        return "Hello";
    }
}
