package com.example.sponsoredads.controller;

import com.example.sponsoredads.model.Campaign;
import com.example.sponsoredads.model.Product;
import com.example.sponsoredads.service.CampaignService;
import com.example.sponsoredads.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/ad")
public class AdController {

    private final CampaignService campaignService;
    private final ProductService productService;

    @Autowired
    public AdController(CampaignService campaignService, ProductService productService) {
        this.campaignService = campaignService;
        this.productService = productService;
    }


    @GetMapping("/serve/{category}")
    public ResponseEntity<Product> retrieveHighestBidProduct(@PathVariable("category") String category) {
        if (category == null || category.isBlank()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Product highestBidProduct = this.productService.findHighestBidProductByCategory(category);
        if (highestBidProduct == null) {
            highestBidProduct = this.productService.findHighestBidProduct();
            if (highestBidProduct == null) {
                return null;
            }
        }
        return new ResponseEntity<>(highestBidProduct, HttpStatus.CREATED);
    }
}
