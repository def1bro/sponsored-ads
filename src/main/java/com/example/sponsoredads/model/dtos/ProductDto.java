package com.example.sponsoredads.model.dtos;

import com.example.sponsoredads.model.Product;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;


@Data
@Builder
public class ProductDto {

    private long id;

    private String serialNumber;

    private String title;

    private String category;

    private BigDecimal price;

    public static ProductDto buildProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .serialNumber(product.getSerialNumber())
                .title(product.getTitle())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();
    }
}
