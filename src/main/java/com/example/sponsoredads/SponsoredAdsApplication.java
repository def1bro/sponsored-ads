package com.example.sponsoredads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SponsoredAdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SponsoredAdsApplication.class, args);
    }

}
