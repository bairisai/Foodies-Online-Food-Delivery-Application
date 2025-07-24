package com.krishnasai.foodiesapi.io;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class OrderRequest {
    private String userId;
    private List<OrderItem> orderedItems;
    private double amount;
    private String userAddress;
}
