package com.rei.examenbackend.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {

    private Long userId;
    private String fullName;
    private String email;
    private String token;
}
