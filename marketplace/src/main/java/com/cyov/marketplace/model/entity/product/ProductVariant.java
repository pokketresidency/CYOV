package com.cyov.marketplace.model.entity.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product_variants")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variantId;

    @Column(name = "product_id")
    private Long productId;

    private String size;

    private String color;

    // Getters and setters
}
