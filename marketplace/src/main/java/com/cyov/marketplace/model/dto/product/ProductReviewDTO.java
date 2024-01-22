package com.cyov.marketplace.model.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewDTO {
    private Long reviewId;
    private Long productId; // To store the product's ID
    private Long userId; // To store the user's ID
    private Integer rating;
    private String comment;
    private String userName; // To store the user's name
    // Other fields related to the product can be added as needed

    // Constructors and getters/setters
}
