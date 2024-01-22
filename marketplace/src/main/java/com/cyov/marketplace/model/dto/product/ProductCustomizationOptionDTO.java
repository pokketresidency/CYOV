package com.cyov.marketplace.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCustomizationOptionDTO {
    private Long customizationId;
    private ProductDTO product; // DTO for Product
    private ProductOptionDTO option; // DTO for ProductOption
    private BigDecimal additionalCost;
}
