package com.example.backend.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private String accessToken;
    private String username;
    private String fullName;
    private String email;
}
