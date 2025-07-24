package com.krishnasai.foodiesapi.io;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {
    private String foodId;
    private int quantity;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
    private String name;
}
