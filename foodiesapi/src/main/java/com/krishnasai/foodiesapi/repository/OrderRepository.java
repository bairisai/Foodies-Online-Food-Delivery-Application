package com.krishnasai.foodiesapi.repository;

import com.krishnasai.foodiesapi.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findOrderByUserId(String userId);
    Optional<OrderEntity> findOrderByRazorpayOrderId(String razorpayOrderId);
}
