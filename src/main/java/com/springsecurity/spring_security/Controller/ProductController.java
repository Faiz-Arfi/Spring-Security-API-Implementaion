package com.springsecurity.spring_security.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private record Product(int id, String name, double price) {}
    private List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "Iphone", 999.99),
                    new Product(2, "Samsung Galaxy", 899.99),
                    new Product(3, "Google Pixel", 799.99)
            )
    );

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }
}
