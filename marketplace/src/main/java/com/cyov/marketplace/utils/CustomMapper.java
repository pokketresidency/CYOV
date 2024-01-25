package com.cyov.marketplace.utils;

import com.cyov.marketplace.model.dto.cart.CartItemDTO;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.cyov.marketplace.model.entity.product.Product;
import com.cyov.marketplace.model.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomMapper {
    public List<CartItemDTO> mapCartItemsToDTO(List<CartItem> cartItems) {
        List<CartItemDTO> cartItemsDTO = cartItems.stream()
                .filter(cartItem -> cartItem.isActive())
                .map(cartItem -> new CartItemDTO(
                        cartItem.getUser().getUserId(),
                        cartItem.getId(),
                        cartItem.getProduct().getProductId(),
                        cartItem.getQuantity(),
                        cartItem.getPrice(),
                        cartItem.getAddedAt()
                ))
                .collect(Collectors.toList());

        return cartItemsDTO;
    }

    public List<CartItem> mapDTOsToCartItems(List<CartItemDTO> cartItemDTOList) {
        List<CartItem> cartItems = cartItemDTOList.stream()
                .map(cartItem -> new CartItem(
                        cartItem.getCartItemId(),
                        new Product(cartItem.getProductId()),
                        cartItem.getQuantity(),
                        cartItem.getPrice(),
                        cartItem.getAddedAt(),
                        new User(cartItem.getUserId()),
                        true

                ))
                .collect(Collectors.toList());

        return cartItems;
    }


}
