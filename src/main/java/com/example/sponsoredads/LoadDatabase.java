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
        productRepository.save(buildProduct("SERIALNUMBER1","Adidas run x1", "Shoes", new BigDecimal(221)));
        productRepository.save(buildProduct("SERIALNUMBER3","Adidas run x3", "Shoes", new BigDecimal(411)));
        productRepository.save(buildProduct("SERIALNUMBER4","Adidas run x2", "Shoes", new BigDecimal(1421)));
        productRepository.save(buildProduct("SERIALNUMBER5","Adidas run x4", "Shoes", new BigDecimal(121)));
        productRepository.save(buildProduct("SERIALNUMBER6","Adidas run x1", "Shoes", new BigDecimal(221)));
        productRepository.save(buildProduct("SERIALNUMBER7","Jacket x3", "Clothing", new BigDecimal(511)));
        productRepository.save(buildProduct("SERIALNUMBER8","Jacket x2", "Clothing", new BigDecimal(1121)));
        productRepository.save(buildProduct("SERIALNUMBER9","Jacket x4", "Clothing", new BigDecimal(9121)));
        productRepository.save(buildProduct("SERIALNUMBER10","Jacket x1", "Clothing", new BigDecimal(3221)));
        productRepository.save(buildProduct("SERIALNUMBER11","Toyota x3", "Cars", new BigDecimal(11411)));
        productRepository.save(buildProduct("SERIALNUMBER12","BMW x2", "Cars", new BigDecimal(41421)));
        productRepository.save(buildProduct("SERIALNUMBER13","Mitsubishi x4", "Cars", new BigDecimal(25121)));
        productRepository.save(buildProduct("SERIALNUMBER14","Mercedes run x4", "Shoes", new BigDecimal(17121)));

    }

    private Product buildProduct(String serialNumber, String title, String category, BigDecimal price){
        return Product.builder()
                .serialNumber(serialNumber)
                .title(title)
                .category(category)
                .price(price)
                .build();
    }
}
