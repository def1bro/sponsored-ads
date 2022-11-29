package com.example.sponsoredads.repository;

import com.example.sponsoredads.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT p.* FROM campaign c " +
            "LEFT JOIN campaign_product cp " +
            "ON c.id = cp.campaign_id " +
            "LEFT JOIN product p " +
            "ON p.id = cp.product_id " +
            "WHERE p.category = :category " +
            "AND NOW() >= c.start_date " +
            "AND (NOW() + 10) > c.start_date " +
            "ORDER BY c.bid DESC LIMIT 1", nativeQuery = true)
    Product findHighestBidProductByCategoryAndActiveCampaign(@Param("category") String category);

    @Query(value = "SELECT p.* FROM campaign c " +
            "LEFT JOIN campaign_product cp " +
            "ON c.id = cp.campaign_id " +
            "LEFT JOIN product p " +
            "ON p.id = cp.product_id " +
            "WHERE NOW() >= c.start_date " +
            "AND (NOW() + 10) > c.start_date " +
            "ORDER BY c.bid DESC LIMIT 1", nativeQuery = true)
    Product findHighestBidProductAndActiveCampaign();

    Product findBySerialNumber(long serialNumber);
}
