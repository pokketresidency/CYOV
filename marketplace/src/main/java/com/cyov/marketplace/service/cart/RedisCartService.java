package com.cyov.marketplace.service.cart;

import com.cyov.marketplace.model.dto.cart.CartRequestDTO;
import com.cyov.marketplace.model.dto.cart.CartResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RedisCartService {

    boolean addItemsToRedisCart(CartRequestDTO cartRequestDTO) throws JsonProcessingException;

    CartResponseDTO fetchCartFromRedis(Long userId) throws JsonProcessingException;
}
