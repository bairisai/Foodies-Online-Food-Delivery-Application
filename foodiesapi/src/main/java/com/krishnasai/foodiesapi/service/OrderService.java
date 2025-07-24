package com.krishnasai.foodiesapi.service;

import com.krishnasai.foodiesapi.io.OrderRequest;
import com.krishnasai.foodiesapi.io.OrderResponse;
import com.razorpay.RazorpayException;

public interface OrderService {
    OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException;
}
