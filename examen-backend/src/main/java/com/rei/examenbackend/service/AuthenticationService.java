package com.rei.examenbackend.service;

import com.rei.examenbackend.dto.auth.AuthRequest;
import com.rei.examenbackend.dto.auth.AuthResponse;
import com.rei.examenbackend.dto.auth.RegisterRequest;

public interface AuthenticationService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}
