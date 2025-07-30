package com.cosodi.pos.service;

import com.cosodi.pos.dto.RegisterRequest;
import com.cosodi.pos.dto.RegisterResponse;

public interface IAuthService {
    
    RegisterResponse registerUser(RegisterRequest request);
    
} 