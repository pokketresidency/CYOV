package com.cyov.marketplace.controller;

import com.cyov.marketplace.model.dto.cart.CartRequestDTO;
import com.cyov.marketplace.model.ServiceResponse;
import com.cyov.marketplace.model.dto.cart.CartResponseDTO;
import com.cyov.marketplace.service.cart.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.cyov.marketplace.model.ServiceResponse.FAILED;
import static com.cyov.marketplace.model.ServiceResponse.SUCCESS;

@RestController
@RequestMapping("/api/v1/cart")
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

    @GetMapping("/fetch/{userId}")
    public ResponseEntity<ServiceResponse<CartResponseDTO>> fetchCartItems(@PathVariable("userId") Long userId) throws JsonProcessingException {
        try{
            CartResponseDTO result = cartService.fetchFromCartObject(userId);
            return ResponseEntity.ok(new ServiceResponse<>(SUCCESS, "Fetched cart items", result));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ServiceResponse<>(FAILED, "Error while fetching cart items", new CartResponseDTO()));
        }
    }
}
