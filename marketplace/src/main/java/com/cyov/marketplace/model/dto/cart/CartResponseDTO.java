package com.cyov.marketplace.model.dto.cart;

import java.io.Serializable;

import com.cyov.marketplace.model.entity.orderflow.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDTO implements Serializable {
    private List<CartItemDTO> cartItems;
}
