package com.cyov.marketplace.model.entity.product;


import jakarta.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(name = "product_id")
    private Long productId;

    private String imageUrl;

    private String altText;

    // Getters and setters
}
