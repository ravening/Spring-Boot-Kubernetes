package com.rakeshv.jkube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class JkubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JkubeApplication.class, args);
    }

}

@RestController
class DemoEndpoint {
    @GetMapping(value = "/hello", produces = "application/json")
    public Flux<HelloResponse> hello() {
        return Flux.just(new HelloResponse("Hello from kubernetes"));
    }
}

class HelloResponse {
    private final String message;

    public HelloResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
