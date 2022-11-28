package com.example.sponsoredads.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
public class Product implements Serializable {


    @Id
    @Column(name = "serial_number", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serialNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private BigDecimal price;


    @ManyToMany(mappedBy = "products")
    private Set<Campaign> campaigns = new java.util.LinkedHashSet<>();

    public Set<Campaign> getCampaigns() {
        return campaigns;
    }

    public Product() {

    }

    public Product(String title, String category, BigDecimal price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "serialNumber=" + serialNumber +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
