package com.cyov.marketplace.service.impl.cart;

import com.cyov.marketplace.model.dto.cart.AddToCartObject;
import com.cyov.marketplace.model.dto.cart.FetchFromCartObject;
import com.cyov.marketplace.service.cart.RedisCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.cyov.marketplace.utils.RedisUtility;

import java.util.List;

@Service
public class RedisCartServiceImpl implements RedisCartService {

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Autowired
    private RedisUtility redisUtility;

    private static final String CART_KEY_PREFIX = "cart:";

    @Override
    public FetchFromCartObject addItemsToCart(AddToCartObject addToCartObject) {
        // Try to fetch the cart from Redis
        FetchFromCartObject cartItems = fetchCartFromRedis(addToCartObject.getUserId());
        if (cartItems == null) {
            // If not in Redis, fetch from DB and update Redis
            cartItems = cartServiceImpl.addItemsToCart(addToCartObject.getUserId(), addToCartObject.getItemDTOs());
            updateCartInRedis(addToCartObject.getUserId(), cartItems);
        }
        return new FetchFromCartObject(cartItems);
    }

    @Override
    public FetchFromCartObject fetchCartFromRedis(Long userId) {
        String key = CART_KEY_PREFIX + userId;
        String cartJson = redisUtility.getValue(key);
        if (cartJson != null) {
            // Deserialize the JSON back to List<CartItem>
            // You need to write the logic for this based on your CartItem structure
            return deserializeCartItems(cartJson);
        }
        return null;
    }

    @Override
    public void updateCartInRedis(Long userId, List<CartItem> cartItems) {
        String key = CART_KEY_PREFIX + userId;
        // Serialize your List<CartItem> to JSON
        // You need to write the logic for this based on your CartItem structure
        String cartJson = serializeCartItems(cartItems);
        redisUtility.setValue(key, cartJson);
    }

    // Add methods for serializeCartItems and deserializeCartItems
    // These methods will handle the conversion between List<CartItem> and JSON string
}
