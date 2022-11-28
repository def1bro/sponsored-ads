package com.example.sponsoredads.service;


import com.example.sponsoredads.model.Product;
import com.example.sponsoredads.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<Product> findProductsById(Set<Long> productIds) {
        Set<Product> products = new HashSet<>();
        productIds.forEach(id -> {
            products.add(productRepository.findById(id).get());
        });

        return products;
    }

    public Product findHighestBidProductByCategory(String category) {
        return this.productRepository.findHighestBidProductByCategory(category);
    }

    public Product findHighestBidProduct() {
        return this.productRepository.findHighestBidProduct();

    }
}
