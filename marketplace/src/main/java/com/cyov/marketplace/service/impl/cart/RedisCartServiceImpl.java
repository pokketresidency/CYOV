package com.cyov.marketplace.service.impl.cart;

import com.cyov.marketplace.model.dto.cart.CartRequestDTO;
import com.cyov.marketplace.model.dto.cart.CartItemDTO;
import com.cyov.marketplace.model.dto.cart.CartResponseDTO;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.cyov.marketplace.model.entity.user.User;
import com.cyov.marketplace.repository.cart.CartItemRepository;
import com.cyov.marketplace.service.cart.RedisCartService;
import com.cyov.marketplace.utils.CustomMapper;
import com.cyov.marketplace.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyov.marketplace.utils.RedisUtility;

import java.util.List;

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
    public boolean addItemsToRedisCart(CartRequestDTO cartRequestDTO) throws JsonProcessingException {

        String key = REDIS_CART_KEY_PREFIX + cartRequestDTO.getUserId();

        redisUtility.setValue(key, cartRequestDTO);
        return true;
    }

    @Override
    public CartResponseDTO fetchCartFromRedis(Long userId) throws JsonProcessingException {
        String key = REDIS_CART_KEY_PREFIX + userId;
        CartResponseDTO redisUtilityValue = redisUtility.getValue(key, CartResponseDTO.class);
        if(!Utils.hasValue(redisUtilityValue) || !Utils.hasValue(redisUtilityValue.getCartItems())) {
            List<CartItem> existingCartItems = cartItemRepository.findByUser(new User(userId));
            List<CartItemDTO> existingCartItemsDTO = customMapper.mapCartItemsToDTO(existingCartItems);

            redisUtilityValue = new CartResponseDTO(existingCartItemsDTO);
            addItemsToRedisCart(new CartRequestDTO(userId, redisUtilityValue.getCartItems()));
        }

        return redisUtilityValue;
    }
}
