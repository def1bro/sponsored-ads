package com.example.sponsoredads.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "campaign")
public class Campaign implements Serializable {

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "campaign_product", joinColumns = @JoinColumn(name = "campaign_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

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
