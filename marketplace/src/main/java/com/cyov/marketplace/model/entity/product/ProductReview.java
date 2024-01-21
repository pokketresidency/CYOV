package com.cyov.marketplace.model.entity.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product_reviews")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;


}