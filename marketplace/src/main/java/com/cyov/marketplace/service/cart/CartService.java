package com.cyov.marketplace.service.cart;

import com.cyov.marketplace.model.dto.cart.CartRequestDTO;
import com.cyov.marketplace.model.dto.cart.CartResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    CartResponseDTO addItemsToCart(CartRequestDTO addToCartObject) throws JsonProcessingException;

    CartResponseDTO fetchFromCartObject(Long userId) throws JsonProcessingException;
}
