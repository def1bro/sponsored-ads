package com.example.sponsoredads.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="campaign_product", joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "campaign_id"))
    private Set<Campaign> campaigns;


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
