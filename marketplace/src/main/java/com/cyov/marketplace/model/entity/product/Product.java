package com.cyov.marketplace.model.entity.product;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "category_id")
    private Long categoryId;

    private String manufacturer;

    private BigDecimal weight;

    private String dimensions;

    // Getters and setters
}
