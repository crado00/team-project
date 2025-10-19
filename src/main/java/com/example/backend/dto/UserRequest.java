package com.example.backend.dto;

import com.example.backend.entity.User;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserRequest {
    private String username;
    private String email;
    private String fullName;

    public static UserRequest from(User user) {
        return UserRequest.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();
    }
}