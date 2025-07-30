package com.cosodi.pos.service.impl;

import com.cosodi.pos.dto.RegisterRequest;
import com.cosodi.pos.dto.RegisterResponse;
import com.cosodi.pos.entity.Role;
import com.cosodi.pos.entity.User;
import com.cosodi.pos.exception.UserAlreadyExistsException;
import com.cosodi.pos.repository.IRoleRepository;
import com.cosodi.pos.repository.IUserRepository;
import com.cosodi.pos.service.IAuthService;
import com.cosodi.pos.util.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse registerUser(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("Username already exists: " + request.getUsername());
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("Email already exists: " + request.getEmail());
        }

        Role defaultRole = roleRepository.findByName(RoleName.READ)
                .orElseThrow(() -> new RuntimeException("Default role not found"));

        User newUser = new User(
                request.getUsername(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getFirstName(),
                request.getLastName(),
                true, // enabled by default
                List.of(defaultRole)
        );

        userRepository.save(newUser);

        return RegisterResponse.success(request.getUsername(), request.getEmail());
    }
} 