package com.cosodi.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {

    private String message;
    private String username;
    private String email;
    private LocalDateTime registrationDate;
    private boolean success;

    public static RegisterResponse success(String username, String email) {
        return new RegisterResponse(
            "User registered successfully",
            username,
            email,
            LocalDateTime.now(),
            true
        );
    }

    public static RegisterResponse error(String message) {
        return new RegisterResponse(
            message,
            null,
            null,
            LocalDateTime.now(),
            false
        );
    }
} 