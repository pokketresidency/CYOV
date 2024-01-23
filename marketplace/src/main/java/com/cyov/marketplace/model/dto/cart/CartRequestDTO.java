package com.cyov.marketplace.model.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequestDTO implements Serializable {
    private Long userId;
    private List<CartItemDTO> cartItems;
}
