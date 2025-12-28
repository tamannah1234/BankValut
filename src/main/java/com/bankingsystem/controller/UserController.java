package com.bankingsystem.controller;

import com.bankingsystem.dto.UserRequest;
import com.bankingsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest request) {
        userService.createUser(request);
        return ResponseEntity.ok("User created successfully");
    }
}
