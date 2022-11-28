package com.example.sponsoredads.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public Set<Product> getproducts() {
        return products;
    }

    public void setproducts(Set<Product> products) {
        this.products = products;
    }

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
