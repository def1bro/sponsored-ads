package com.example.sponsoredads.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@Table(name = "campaigns")
public class Campaign implements Serializable {

    public Campaign() {
    }

    public Campaign(String name, Date startDate, BigDecimal bid, Set<Product> products) {
        this.name = name;
        this.startDate = startDate;
        this.bid = bid;
        this.products = products;
    }


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "bid")
    private BigDecimal bid;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "campaigns_products",
            joinColumns = {
                    @JoinColumn(name = "campaign_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "product_serialNumber", referencedColumnName = "serial_number",
                            nullable = false, updatable = false)})
    private Set<Product> products = new HashSet<>();


    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", bid=" + bid +
                ", products=" + products +
                '}';
    }
}
