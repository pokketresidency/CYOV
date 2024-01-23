package com.cyov.marketplace.service.cart;

import com.cyov.marketplace.model.dto.cart.AddToCartObject;
import com.cyov.marketplace.model.dto.cart.FetchFromCartObject;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface RedisCartService {

    boolean addItemsToRedisCart(AddToCartObject addToCartObject) throws JsonProcessingException;

    FetchFromCartObject fetchCartFromRedis(Long userId) throws JsonProcessingException;
}
