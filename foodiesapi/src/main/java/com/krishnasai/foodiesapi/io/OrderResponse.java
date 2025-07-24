package com.krishnasai.foodiesapi.io;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
    private String id;
    private String userId;
    private String userAddress;
    private String phoneNumber;
    private double amount;
    private String paymentStatus;
    private String razorpayOrderId;
    private String orderStatus;
}
