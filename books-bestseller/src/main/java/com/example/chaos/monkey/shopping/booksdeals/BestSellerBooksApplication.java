package com.example.chaos.monkey.shopping.booksdeals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BestSellerBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestSellerBooksApplication.class, args);
	}

}
