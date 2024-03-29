package com.cyov.marketplace.service.impl.cart;

import com.cyov.marketplace.model.dto.cart.CartRequestDTO;
import com.cyov.marketplace.model.dto.cart.CartItemDTO;
import com.cyov.marketplace.model.dto.cart.CartResponseDTO;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.cyov.marketplace.model.entity.product.Product;
import com.cyov.marketplace.model.entity.user.User;
import com.cyov.marketplace.repository.cart.CartItemRepository;
import com.cyov.marketplace.repository.product.ProductRepository;
import com.cyov.marketplace.repository.user.UserRepository;
import com.cyov.marketplace.service.cart.CartService;
import com.cyov.marketplace.service.cart.RedisCartService;
import com.cyov.marketplace.utils.CustomMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RedisCartService redisCartService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomMapper customMapper;

    @Override
    public CartResponseDTO addItemsToCart(CartRequestDTO addToCartObject) throws JsonProcessingException {
        User user = userRepository.findById(addToCartObject.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        CartResponseDTO cartPresentInRedis = redisCartService.fetchCartFromRedis(addToCartObject.getUserId());
//        List<CartItemDTO> existingCartItems = cartPresentInRedis.getCartItems().stream().toList();

        List<CartItem> existingCartItems = customMapper.mapDTOsToCartItems(cartPresentInRedis.getCartItems());

        // Process new items
        for (CartItemDTO itemDTO : addToCartObject.getCartItems()) {
            Product product = productRepository.findById(itemDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            Optional<CartItem> existingItem = existingCartItems.stream()
                    .filter(cartItem -> cartItem.getProduct().getProductId().equals(product.getProductId()))
                    .findFirst();

            if (existingItem.isPresent()) {
                // Update quantity if item already exists in cart
                CartItem cartItem = existingItem.get();
                cartItem.setQuantity(cartItem.getQuantity() + itemDTO.getQuantity());
            } else {
                // Add new item to cart
                CartItem newItem = new CartItem();
                newItem.setProduct(product);
                newItem.setQuantity(itemDTO.getQuantity());
                newItem.setPrice(product.getPrice());
                newItem.setUser(user);
                newItem.setAddedAt(LocalDateTime.now());
                existingCartItems.add(newItem);
            }
        }
        List<CartItemDTO> existingCartItemsDTO = customMapper.mapCartItemsToDTO(existingCartItems);
        redisCartService.addItemsToRedisCart(new CartRequestDTO(addToCartObject.getUserId(), existingCartItemsDTO));
        List<CartItem> updatedCartItems = cartItemRepository.saveAll(existingCartItems);

        return new CartResponseDTO(existingCartItemsDTO);
    }

    @Override
    public CartResponseDTO deleteCartItems(CartRequestDTO deleteFromCartRequestDTO) throws JsonProcessingException {
        User user = userRepository.findById(deleteFromCartRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        CartResponseDTO cartPresentInRedis = redisCartService.fetchCartFromRedis(deleteFromCartRequestDTO.getUserId());
//        List<CartItemDTO> existingCartItems = cartPresentInRedis.getCartItems().stream().toList();

        List<CartItem> existingCartItems = customMapper.mapDTOsToCartItems(cartPresentInRedis.getCartItems());

        // Process new items
        for (CartItemDTO itemDTO : deleteFromCartRequestDTO.getCartItems()) {
            Product product = productRepository.findById(itemDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            Optional<CartItem> existingItem = existingCartItems.stream()
                    .filter(cartItem -> cartItem.getProduct().getProductId().equals(product.getProductId()))
                    .findFirst();

            if (existingItem.isPresent()) {
                // Update quantity if item already exists in cart
                CartItem cartItem = existingItem.get();
                Integer updatedQuatitiy = cartItem.getQuantity() - itemDTO.getQuantity() > 0 ? cartItem.getQuantity() - itemDTO.getQuantity() : 0;
                cartItem.setQuantity(updatedQuatitiy);
            }
        }
        List<CartItemDTO> existingCartItemsDTO = customMapper.mapCartItemsToDTO(existingCartItems);
        redisCartService.addItemsToRedisCart(new CartRequestDTO(deleteFromCartRequestDTO.getUserId(), existingCartItemsDTO));
        List<CartItem> updatedCartItems = cartItemRepository.saveAll(existingCartItems);

        return new CartResponseDTO(existingCartItemsDTO);
    }

    @Override
    public CartResponseDTO fetchFromCartObject(Long userId) throws JsonProcessingException {
        return redisCartService.fetchCartFromRedis(userId);
    }

}
