package com.cyov.marketplace.model.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_customization_options")
public class ProductCustomizationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customizationId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id")
    private ProductOption option;

    @Column(name = "additional_cost")
    private BigDecimal additionalCost;

    // Getters and setters
}
