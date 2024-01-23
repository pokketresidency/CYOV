package com.cyov.marketplace.controller;

import com.cyov.marketplace.model.dto.cart.CartRequestDTO;
import com.cyov.marketplace.model.ServiceResponse;
import com.cyov.marketplace.model.dto.cart.CartResponseDTO;
import com.cyov.marketplace.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.cyov.marketplace.model.ServiceResponse.FAILED;
import static com.cyov.marketplace.model.ServiceResponse.SUCCESS;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<ServiceResponse<CartResponseDTO>> addItemToCart(@RequestBody CartRequestDTO itemDTO) {
        try {
            CartResponseDTO addedItem = cartService.addItemsToCart(itemDTO);
            return ResponseEntity.ok(new ServiceResponse<>(SUCCESS, "Added to cart", new CartResponseDTO(addedItem.getCartItems())));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ServiceResponse<>(FAILED,"Error processing cart item", new CartResponseDTO()));
        }
    }
}
