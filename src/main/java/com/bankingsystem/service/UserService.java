package com.bankingsystem.service;

import com.bankingsystem.dto.UserRequest;
import com.bankingsystem.entity.User;

public interface UserService {
    User createUser(UserRequest request);
}
