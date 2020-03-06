package com.rakeshv.configmaps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
@Slf4j
public class WelcomeController {

    @Value("${message: Welcome hello world}")
    private String message;
    @GetMapping
    public String welcome() {
        log.info("{}", message);
        return message;
    }
}
