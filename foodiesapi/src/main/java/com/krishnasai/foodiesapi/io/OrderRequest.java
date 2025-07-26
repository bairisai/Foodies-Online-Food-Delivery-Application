package com.krishnasai.foodiesapi.io;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class OrderRequest {
    private List<OrderItem> orderedItems;
    private double amount;
    private String userAddress;
    private String email;
    private String phoneNumber;
    private String orderStatus;
}
