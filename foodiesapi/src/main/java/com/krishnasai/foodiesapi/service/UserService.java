package com.krishnasai.foodiesapi.service;

import com.krishnasai.foodiesapi.io.UserRequest;
import com.krishnasai.foodiesapi.io.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);
    String findUserId();
}
