package com.krishnasai.foodiesapi.service;

import com.krishnasai.foodiesapi.io.CartRequest;
import com.krishnasai.foodiesapi.io.CartResponse;

public interface CartService {
    CartResponse addToCart(CartRequest request);
    CartResponse getCart();

    void clearCart();

    CartResponse removeFromCart(CartRequest cartRequest);
}
