package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@RestController
public class K8sDemoAppApplication {
	@Autowired
	NameServiceClient nameServiceClient;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final RestTemplate restTemplate = new RestTemplateBuilder().build();

	public static void main(String[] args) {
		SpringApplication.run(K8sDemoAppApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		logger.info("Fetching the name");
		String name = restTemplate.getForObject("http://k8s-workshop-name-service", String.class);
		String feignString = nameServiceClient.getName();
		return "Hola " + name + " from resttemplate : Name from feign client is " + feignString + "\n";
	}
}
