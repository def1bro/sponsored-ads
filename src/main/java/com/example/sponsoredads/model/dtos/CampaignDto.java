package com.example.sponsoredads.model.dtos;

import com.example.sponsoredads.model.Campaign;
import com.example.sponsoredads.model.Product;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


//@TODO continue DTO

@Data
public class CampaignDto {

    @NotNull("Name of campaign is required.")
    private String name;


    @NotNull("The start date is required.")
    @FutureOrPresent(message = "The start date must be today or in the future.")
    private Date startDate;

    @NotNull("The bid is required.")
    @Positive(message = "Bid must be a positive number.")
    private BigDecimal bid;

    @NotNull("Product ids are required.")
    private Set<Product> products;


/*    public Campaign toCampaign() {
        return new Campaign()
                .setName(name)

    }*/
}
