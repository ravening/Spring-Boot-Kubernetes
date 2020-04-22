package com.rakeshv.configserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @GetMapping
    public List<String> getUsers() {
        log.info("Received a request from client@!!!!!!");

        return Arrays.asList(
                "Spring",
                "boot",
                "Cloud",
                "Kubernetes",
                "Configmap",
                "Discoveryclient",
                "Discoveryserver"
        );
    }

    @GetMapping("/test")
    public String test() {
        log.info("testing the skaffold");
        return "Hello";
    }
}
