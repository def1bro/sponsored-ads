package com.example.sponsoredads.repository;

import com.example.sponsoredads.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT p.* FROM products" +
            " LEFT JOIN campaigns_products cp ON p.serial_number = cp.product_serial_number" +
            " LEFT JOIN campaigns c ON cp.campaign_id = c.id " +
            "WHERE p.category = :category " +
            "AND CURDATE() > c.start_date AND CURDATE() + INTERVAL 10 DAY > c.start_date" +
            " ORDER BY c.bid DESC LIMIT 1",
            nativeQuery = true
    )
    Product findHighestBidProductByCategory(@Param("category") String category);

    @Query(value = "SELECT p.* FROM products " +
            "LEFT JOIN campaigns_products cp " +
            "ON p.serial_number = cp.product_serial_number " +
            "LEFT JOIN campaigns c " +
            "ON cp.campaign_id = c.id " +
            "AND CURDATE() > c.start_date AND CURDATE() + INTERVAL 10 DAY > c.start_date " +
            "ORDER BY c.bid DESC LIMIT 1",
            nativeQuery = true
    )
    Product findHighestBidProduct();

    Product findBySerialNumber(long serialNumber);
}
