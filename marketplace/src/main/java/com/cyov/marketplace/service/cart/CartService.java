package com.cyov.marketplace.service.cart;

import com.cyov.marketplace.model.dto.cart.AddToCartObject;
import com.cyov.marketplace.model.dto.cart.CartItemDTO;
import com.cyov.marketplace.model.dto.cart.CartRequestDTO;
import com.cyov.marketplace.model.dto.cart.FetchFromCartObject;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    FetchFromCartObject addItemsToCart(CartRequestDTO addToCartObject) throws JsonProcessingException;

    FetchFromCartObject fetchFromCartObject(AddToCartObject addToCartObject) throws JsonProcessingException;
}
