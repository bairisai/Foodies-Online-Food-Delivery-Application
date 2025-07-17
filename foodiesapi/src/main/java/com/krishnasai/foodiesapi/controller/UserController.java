package com.krishnasai.foodiesapi.controller;

import com.krishnasai.foodiesapi.io.UserRequest;
import com.krishnasai.foodiesapi.io.UserResponse;
import com.krishnasai.foodiesapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerUser(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }
}
