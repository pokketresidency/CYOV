package com.cyov.marketplace.service.cart;

import com.cyov.marketplace.model.dto.cart.AddToCartObject;
import com.cyov.marketplace.model.dto.cart.FetchFromCartObject;

public interface RedisCartService {
    FetchFromCartObject addItemsToCart(AddToCartObject addToCartObject);
}
