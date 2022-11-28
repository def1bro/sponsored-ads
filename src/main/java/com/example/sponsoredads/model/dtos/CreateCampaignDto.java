package com.example.sponsoredads.model.dtos;

import com.example.sponsoredads.model.Campaign;
import com.example.sponsoredads.model.Product;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


@Data
public class CreateCampaignDto {

    @NotNull("Name of campaign is required.")
    private String name;


    @NotNull("The start date is required.")
    @FutureOrPresent(message = "The start date must be today or in the future.")
    private Date startDate;

    @NotNull("The bid is required.")
    @Positive(message = "Bid must be a positive number(BigDecimal type).")
    private BigDecimal bid;

    @NotNull("Product ids are required.")
    private Set<BigDecimal> productIds;


    public Campaign toCampaign(Set<Product> products) {
        return Campaign.builder()
                .name(name)
                .startDate(startDate)
                .bid(bid)
                .products(products)
                .build();
    }
}
