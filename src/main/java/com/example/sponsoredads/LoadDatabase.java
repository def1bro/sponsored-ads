package com.example.sponsoredads;

import com.example.sponsoredads.model.Product;
import com.example.sponsoredads.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;

@Component
public class LoadDatabase implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        productRepository.save(new Product("Adidas run x1", "Shoes", new BigDecimal(221)));
        productRepository.save(new Product("Adidas run x3", "Shoes", new BigDecimal(411)));
        productRepository.save(new Product("Adidas run x2", "Shoes", new BigDecimal(1421)));
        productRepository.save(new Product("Adidas run x4", "Shoes", new BigDecimal(121)));
        productRepository.save(new Product("Adidas run x1", "Shoes", new BigDecimal(221)));
        productRepository.save(new Product("Jacket x3", "Clothing", new BigDecimal(511)));
        productRepository.save(new Product("Jacket x2", "Clothing", new BigDecimal(1121)));
        productRepository.save(new Product("Jacket x4", "Clothing", new BigDecimal(9121)));
        productRepository.save(new Product("Jacket x1", "Clothing", new BigDecimal(3221)));
        productRepository.save(new Product("Toyota x3", "Cars", new BigDecimal(11411)));
        productRepository.save(new Product("BMW x2", "Cars", new BigDecimal(41421)));
        productRepository.save(new Product("Mitsubishi x4", "Cars", new BigDecimal(25121)));
        productRepository.save(new Product("Mercedes run x4", "Shoes", new BigDecimal(17121)));

    }
}
