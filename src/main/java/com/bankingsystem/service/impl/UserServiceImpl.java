package com.bankingsystem.service.impl;

import com.bankingsystem.dto.UserRequest;
import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.User;
import com.bankingsystem.repository.UserRepository;
import com.bankingsystem.service.UserService;
import com.bankingsystem.util.AccountStatus;
import com.bankingsystem.util.Role;
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
    public void createUser(UserRequest request) {

        // 1️⃣ Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // 2️⃣ Create user entity
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // encrypt password
        user.setRole(Role.USER); // backend controls role

        // 3️⃣ Create default account for the user
        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(0.0);
        account.setStatus(AccountStatus.ACTIVE);
        account.setUser(user);

        // 4️⃣ Link account to user
        user.getAccounts().add(account);

        // 5️⃣ Save user (cascade saves the account as well)
        userRepository.save(user); // ✅ no return
    }

    // Generate a simple random account number
    private String generateAccountNumber() {
        return "ACC" + (long)(Math.random() * 1_000_000_000L);
    }
}
