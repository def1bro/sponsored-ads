package com.example.sponsoredads.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
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


    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
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
