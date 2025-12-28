package com.bankingsystem.service.impl;

import com.bankingsystem.dto.UserRequest;
import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.User;
import com.bankingsystem.repository.UserRepository;
import com.bankingsystem.service.UserService;
import com.bankingsystem.util.AccountStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(UserRequest request) {

        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Create user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 🔐 Encrypt
        user.setRole(request.getRole());

        // Create default account for the new user
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(0.0);
        account.setStatus(AccountStatus.ACTIVE);
        account.setUser(user);

        // Link account to user
        user.getAccounts().add(account);

        // Save user (cascade saves the account as well)
        return userRepository.save(user);
    }

    // Simple method to generate random unique account number
    private String generateAccountNumber() {
        return "ACC" + (long)(Math.random() * 1_000_000_000L);
    }
}
