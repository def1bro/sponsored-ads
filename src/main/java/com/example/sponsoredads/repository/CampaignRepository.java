package com.example.sponsoredads.repository;

import com.example.sponsoredads.model.Campaign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends CrudRepository<Campaign, Long> {
}
