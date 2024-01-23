package com.cyov.marketplace.model.dto.cart;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO{
    private Long userId;
    private Long cartItemId;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;
    private LocalDateTime addedAt;
}