package com.example.sponsoredads.service;


import com.example.sponsoredads.model.Campaign;
import com.example.sponsoredads.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public Campaign createNewCampaign(Campaign campaign) {
        return this.campaignRepository.save(campaign);
    }

    public List<Campaign> getAllCampaigns() {
        List<Campaign> campaigns = new LinkedList<>();
        this.campaignRepository.findAll().forEach(campaigns::add);

        return campaigns;
    }
}
