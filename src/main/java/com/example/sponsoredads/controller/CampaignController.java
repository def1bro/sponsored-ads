package com.example.sponsoredads.controller;


import com.example.sponsoredads.exceptions.ResourceNotFoundException;
import com.example.sponsoredads.model.Campaign;
import com.example.sponsoredads.model.Product;
import com.example.sponsoredads.model.dtos.CreateCampaignDto;
import com.example.sponsoredads.service.CampaignService;
import com.example.sponsoredads.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/campaign")
public class CampaignController {

    private final CampaignService campaignService;
    private final ProductService productService;

    @Autowired
    public CampaignController(CampaignService campaignService, ProductService productService) {
        this.campaignService = campaignService;
        this.productService = productService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody CreateCampaignDto createCampaignDto) throws ResourceNotFoundException {
        if (createCampaignDto == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Set<Product> products = productService.findProductsById(Set.copyOf(createCampaignDto.getProductIds()));
        if (products.isEmpty() || products == null) {
            System.out.println("[CampaignController] no matching products found");
            throw new ResourceNotFoundException("No product ids were found with the provided: " + createCampaignDto.getProductIds());
        }

        Campaign campaignInput = createCampaignDto.toCampaign(products);
        Campaign createdCampaign = this.campaignService.createNewCampaign(campaignInput);
        return new ResponseEntity<>(createdCampaign, HttpStatus.CREATED);
    }

}
