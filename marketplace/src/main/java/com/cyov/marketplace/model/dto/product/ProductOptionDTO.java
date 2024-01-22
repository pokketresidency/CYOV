package com.cyov.marketplace.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOptionDTO {
    private Long id;
    private String optionType;
    private String optionValue;
}
