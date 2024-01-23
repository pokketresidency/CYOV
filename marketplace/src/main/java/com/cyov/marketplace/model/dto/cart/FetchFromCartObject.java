package com.cyov.marketplace.model.dto.cart;


import com.cyov.marketplace.model.entity.orderflow.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchFromCartObject {
    private List<CartItemDTO> cartItems;
}
