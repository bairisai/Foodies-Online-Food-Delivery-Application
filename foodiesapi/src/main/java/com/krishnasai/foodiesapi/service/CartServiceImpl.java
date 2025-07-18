package com.krishnasai.foodiesapi.service;

import com.krishnasai.foodiesapi.entity.CartEntity;
import com.krishnasai.foodiesapi.io.CartRequest;
import com.krishnasai.foodiesapi.io.CartResponse;
import com.krishnasai.foodiesapi.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final UserService userService;

    @Override
    public CartResponse addToCart(CartRequest request) {
        String loggedInUser = userService.findUserId();
        Optional<CartEntity> cartOptional = cartRepository.findByUserId(loggedInUser);
        CartEntity cart = cartOptional.orElseGet(() -> new CartEntity(loggedInUser, new HashMap<>()));
        Map<String, Integer> cartItems = cart.getItems();
        cartItems.put(request.getFoodId(), cartItems.getOrDefault(request.getFoodId(), 0) + 1);
        cart.setItems(cartItems);
        cart = cartRepository.save(cart);
        return convertoResponse(cart);
    }

    @Override
    public CartResponse getCart() {
        String loggedInUserId = userService.findUserId();
        CartEntity entity = cartRepository.findByUserId(loggedInUserId)
                .orElse(new CartEntity(null, loggedInUserId, new HashMap<>()));
        return convertoResponse(entity);
    }

    @Override
    public void clearCart() {
        String loggedInUserId = userService.findUserId();
        cartRepository.deleteByUserId(loggedInUserId);
    }

    @Override
    public CartResponse removeFromCart(CartRequest cartRequest) {
        String loggedInUserId = userService.findUserId();
        CartEntity cartEntity = cartRepository.findByUserId(loggedInUserId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Map<String, Integer> cartItems = cartEntity.getItems();
        if (cartItems.containsKey(cartRequest.getFoodId())) {
            int currQty = cartItems.get(cartRequest.getFoodId());
            if (currQty > 0) {
                cartItems.put(cartRequest.getFoodId(), currQty - 1);
            } else {
                cartItems.remove(cartRequest.getFoodId());
            }
            cartEntity = cartRepository.save(cartEntity);
        }
        return convertoResponse(cartEntity);
    }

    private CartResponse convertoResponse(CartEntity cartEntity) {
        return CartResponse.builder()
                .id(cartEntity.getId())
                .userId(cartEntity.getUserId())
                .items(cartEntity.getItems())
                .build();
    }
}
