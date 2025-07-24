package com.krishnasai.foodiesapi.service;

import com.krishnasai.foodiesapi.entity.OrderEntity;
import com.krishnasai.foodiesapi.io.OrderRequest;
import com.krishnasai.foodiesapi.io.OrderResponse;
import com.krishnasai.foodiesapi.repository.OrderRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.AllArgsConstructor;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    @Value("${razorpay_key}")
    private String RAZORPAY_KEY;
    @Value("${razorpay_secret_key}")
    private String RAZORPAY_SECRET_KEY;
    @Override
    public OrderResponse createOrderWithPayment(OrderRequest request) throws RazorpayException {
        OrderEntity newOrder = convertToEntity(request);
        newOrder = orderRepository.save(newOrder);

        //create razorpay payment order
        RazorpayClient razorpayClient = new RazorpayClient(RAZORPAY_KEY, RAZORPAY_SECRET_KEY);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", newOrder.getAmount());
        orderRequest.put("currency", "INR");
        orderRequest.put("paymentCapture", 1);

        Order razorpayOrder = razorpayClient.orders.create(orderRequest);
        newOrder.setRazorpayOrderId(razorpayOrder.get("id"));
    }
    private OrderEntity convertToEntity(OrderRequest request) {
        return OrderEntity.builder()
                .userId(request.getUserId())
                .amount(request.getAmount())
                .orderedItems(request.getOrderedItems())
                .userAddress(request.getUserAddress())
                .build();
    }
}
