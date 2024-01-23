package com.cyov.marketplace.service.impl.cart;

import com.cyov.marketplace.model.dto.cart.AddToCartObject;
import com.cyov.marketplace.model.dto.cart.CartItemDTO;
import com.cyov.marketplace.model.dto.cart.FetchFromCartObject;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.cyov.marketplace.model.entity.user.User;
import com.cyov.marketplace.repository.cart.CartItemRepository;
import com.cyov.marketplace.service.cart.RedisCartService;
import com.cyov.marketplace.utils.CustomMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyov.marketplace.utils.RedisUtility;

import java.util.List;
import java.util.stream.Collectors;

import static com.cyov.marketplace.constants.AppConstants.REDIS_CART_KEY_PREFIX;

@Service
public class RedisCartServiceImpl implements RedisCartService {

    @Autowired
    private RedisUtility redisUtility;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CustomMapper customMapper;


    @Override
    public boolean addItemsToRedisCart(AddToCartObject addToCartObject) throws JsonProcessingException {

        String key = REDIS_CART_KEY_PREFIX + addToCartObject.getUserId();

        redisUtility.setValue(key, addToCartObject);
        return true;
    }

    @Override
    public FetchFromCartObject fetchCartFromRedis(Long userId) throws JsonProcessingException {
        String key = REDIS_CART_KEY_PREFIX + userId;
        FetchFromCartObject redisUtilityValue = redisUtility.getValue(key, FetchFromCartObject.class);
        if(redisUtilityValue == null) {
            List<CartItem> existingCartItems = cartItemRepository.findByUser(new User(userId));
            List<CartItemDTO> existingCartItemsDTO = customMapper.mapCartItemsToDTO(existingCartItems);

            redisUtilityValue = new FetchFromCartObject(existingCartItemsDTO);
            addItemsToRedisCart(new AddToCartObject(userId, redisUtilityValue.getCartItems()));
        }

        return redisUtilityValue;
    }
}
