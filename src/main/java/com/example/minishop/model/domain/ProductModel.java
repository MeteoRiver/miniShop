package com.example.minishop.model.domain;

import com.example.minishop.model.entity.mysql.Category;
import com.example.minishop.model.entity.mysql.Product;
import com.example.minishop.model.entity.mysql.Review;
import com.example.minishop.model.entity.mysql.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Category category;
    private String imageUrls;
    private User sellerId;

    public static ProductModel fromEntity(Product product) {
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .createdAt(product.getCreatedAt())
                .category(product.getCategory().getName())
                .imageUrls(product.getImageUrls())
                .sellerId(product.getSeller().getId())
                .build();
    }
}
