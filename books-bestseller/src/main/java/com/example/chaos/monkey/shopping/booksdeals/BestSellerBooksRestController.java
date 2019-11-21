package com.example.chaos.monkey.shopping.booksdeals;

import com.example.chaos.monkey.shopping.domain.Product;
import com.example.chaos.monkey.shopping.domain.ProductBuilder;
import com.example.chaos.monkey.shopping.domain.ProductCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/books")
public class BestSellerBooksRestController {

    private String appid = UUID.randomUUID().toString();
    @GetMapping("/bestseller")
    public List<Product> getBestSellerBooks(HttpServletResponse response) {
        response.addHeader("appid", appid);
        AtomicLong aLong = new AtomicLong(21);

        ProductBuilder productBuilder = new ProductBuilder();
        Product product = productBuilder.setCategory(ProductCategory.BOOKS)
                                        .setName("Microservices")
                                        .setId(aLong.getAndIncrement()).createProduct();

        Product product1 = productBuilder.setCategory(ProductCategory.BOOKS)
                                         .setId(aLong.getAndIncrement())
                                         .setName("Getting Started with Spring boot").createProduct();

        Product product2 = productBuilder.setCategory(ProductCategory.BOOKS)
                                         .setName("Kubernetes Up and Running")
                                         .setId(aLong.getAndIncrement()).createProduct();

        return Arrays.asList(product, product1, product2);
    }
}
