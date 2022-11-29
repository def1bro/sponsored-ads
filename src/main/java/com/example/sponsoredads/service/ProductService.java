package com.example.sponsoredads.service;


import com.example.sponsoredads.model.Product;
import com.example.sponsoredads.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<Product> findProductsByIds(Set<Long> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            return Collections.emptySet();
        }
        return StreamSupport.stream(productRepository.findAllById(productIds).spliterator(), false)
                .collect(Collectors.toSet());
    }

    public Product findHighestBidProductByCategoryAndActiveCampaign(String category) {
        return this.productRepository.findHighestBidProductByCategoryAndActiveCampaign(category);
    }

    public Product findHighestBidProductAndActiveCampaign() {
        return this.productRepository.findHighestBidProductAndActiveCampaign();

    }
}
