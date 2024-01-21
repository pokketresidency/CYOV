package com.cyov.marketplace.model.entity.product;

import jakarta.persistence.*;

@Entity
@Table(name = "product_inventory")
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "variant_id")
    private Long variantId;

    private Integer quantityAvailable;

    // Getters and setters
}
