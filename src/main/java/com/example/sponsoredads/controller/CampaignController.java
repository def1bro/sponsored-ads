package com.example.sponsoredads.controller;


import com.example.sponsoredads.exceptions.ResourceNotFoundException;
import com.example.sponsoredads.model.Campaign;
import com.example.sponsoredads.model.Product;
import com.example.sponsoredads.model.dtos.CampaignDto;
import com.example.sponsoredads.service.CampaignService;
import com.example.sponsoredads.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
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

    /***
     * Create campaign from the provided values
     * @param createCampaignDto - name, startDate, productIds, bid
     * @return Campaign - created campaign
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Campaign> createCampaign(@Valid @RequestBody CampaignDto createCampaignDto) throws ResourceNotFoundException {
        if (createCampaignDto == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Set<Product> products = productService.findProductsByIds(createCampaignDto.getProductIds());
        if (products.isEmpty()) {
            log.error("[CampaignController] no matching products found");
            throw new ResourceNotFoundException("No product ids were found with the provided: " + createCampaignDto.getProductIds());
        }

        Campaign campaignInput = createCampaignDto.toCampaign(products);
        Campaign createdCampaign = this.campaignService.createNewCampaign(campaignInput);
        return new ResponseEntity<>(createdCampaign, HttpStatus.CREATED);
    }

}
