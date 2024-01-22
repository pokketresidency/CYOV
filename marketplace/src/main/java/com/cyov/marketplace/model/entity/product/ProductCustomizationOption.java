package com.cyov.marketplace.model.entity.product;

import jakarta.persistence.*;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
