package com.kyrie.security.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    public record Product(int id, String name, int price) {}

    private final List<Product> products = new ArrayList<>();

    // Constructor to initialize some products
    public ProductController() {
        products.add(new Product(1, "Mac", 100));
        products.add(new Product(2, "iPhone", 200));
    }

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        products.add(product);
        return "Product saved: " + product.name();
    }
}
