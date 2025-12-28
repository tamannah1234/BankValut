package com.bankingsystem.dto;

import com.bankingsystem.util.Role;

public class UserRequest {

    private String name;
    private String email;
    private String password;
    private Role role;

    // No-args constructor
    public UserRequest() {
    }

    // Getter & Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter & Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter & Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter & Setter for role
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
