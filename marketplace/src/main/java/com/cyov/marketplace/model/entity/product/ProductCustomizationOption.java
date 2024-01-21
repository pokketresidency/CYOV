package com.cyov.marketplace.model.entity.product;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_customization_options")
public class ProductCustomizationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customizationId;

    @Column(name = "product_id")
    private Long productId;

    private String optionType;

    private BigDecimal additionalCost;

    // Getters and setters
}
