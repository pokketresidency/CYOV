package com.cyov.marketplace.service.cart;

import com.cyov.marketplace.model.dto.cart.CartItemDTO;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<CartItem> addItemsToCart(Long userId, List<CartItemDTO> itemDTOs);
}
