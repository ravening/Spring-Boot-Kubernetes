package com.rakeshv.configserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/test")
    public String test() {
        log.info("hello dude");
        return "hello !!!!!!sdfsfdide";
    }
}
