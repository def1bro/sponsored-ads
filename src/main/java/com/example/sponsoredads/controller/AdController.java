package com.example.sponsoredads.controller;

import com.example.sponsoredads.model.Product;
import com.example.sponsoredads.model.dtos.ProductDto;
import com.example.sponsoredads.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ad")
public class AdController {

    private final ProductService productService;

    @Autowired
    public AdController(ProductService productService) {
        this.productService = productService;
    }

    /***
     *
     * @param category
     * @return
     */
    @GetMapping("/serve/{category}")
    public ResponseEntity<ProductDto> retrieveHighestBidProduct(@PathVariable("category") String category) {
        if (category == null || category.isBlank()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Product highestBidProduct = productService.findHighestBidProductByCategoryAndActiveCampaign(category);
        if (highestBidProduct == null) {
            highestBidProduct = productService.findHighestBidProductAndActiveCampaign();
            if (highestBidProduct == null) {
                return null;
            }
        }

        return new ResponseEntity<>(ProductDto.buildProductDto(highestBidProduct), HttpStatus.CREATED);
    }
}
