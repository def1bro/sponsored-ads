package com.example.sponsoredads.controller;


import com.example.sponsoredads.model.Campaign;
import com.example.sponsoredads.service.CampaignService;
import com.example.sponsoredads.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/campaign")
public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {

        //@todo handle validations or use DTO
        if(campaign == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }


        Campaign createdCampaign = this.campaignService.createNewCampaign(campaign);
        return new ResponseEntity<>(createdCampaign, HttpStatus.CREATED);
    }

}
