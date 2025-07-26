package com.krishnasai.foodiesapi.controller;

import com.krishnasai.foodiesapi.io.OrderRequest;
import com.krishnasai.foodiesapi.io.OrderResponse;
import com.krishnasai.foodiesapi.service.OrderService;
import com.razorpay.RazorpayException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrderWithPayment(@RequestBody OrderRequest request) throws RazorpayException {
        OrderResponse response = orderService.createOrderWithPayment(request);
        return response;
    }
    @PostMapping("/verify")
    public void verifyPayment(@RequestBody Map<String, String> paymentData) {
        orderService.verifyPayment(paymentData, "paid");
    }

    @GetMapping
    public List<OrderResponse> getOrders() {
        return orderService.getUserOrders();
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable String orderId) {
        orderService.removeOrder(orderId);
    }

    //Admin Panel
    @GetMapping("all")
    public List<OrderResponse> getOrdersOfAllUsers() {
        return orderService.getOrdersOfAllUsers();
    }

    //Admin Panel
    @PatchMapping("/status/{orderId}")
    public void updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
         orderService.updateOrderStatus(orderId, status);
    }
}
