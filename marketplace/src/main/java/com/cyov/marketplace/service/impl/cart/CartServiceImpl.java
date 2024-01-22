package com.cyov.marketplace.service.impl.cart;

import com.cyov.marketplace.model.dto.cart.CartItemDTO;
import com.cyov.marketplace.model.dto.cart.FetchFromCartObject;
import com.cyov.marketplace.model.entity.orderflow.CartItem;
import com.cyov.marketplace.model.entity.product.Product;
import com.cyov.marketplace.model.entity.user.User;
import com.cyov.marketplace.repository.cart.CartItemRepository;
import com.cyov.marketplace.repository.product.ProductRepository;
import com.cyov.marketplace.repository.user.UserRepository;
import com.cyov.marketplace.service.cart.CartService;
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
    private UserRepository userRepository;

    public FetchFromCartObject addItemsToCart(Long userId, List<CartItemDTO> itemDTOs) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch existing cart items for the user
        List<CartItem> existingCartItems = cartItemRepository.findByUser(user);

        // Process new items
        for (CartItemDTO itemDTO : itemDTOs) {
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

        return cartItemRepository.saveAll(existingCartItems);
    }

}
