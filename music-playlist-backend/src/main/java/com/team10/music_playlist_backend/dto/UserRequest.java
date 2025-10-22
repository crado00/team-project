package com.team10.music_playlist_backend.dto;

import com.team10.music_playlist_backend.entity.User;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserRequest {
    private String username;
    private String email;
    private String fullName;
    private String password;

    public static UserRequest from(User user) {
        return UserRequest.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .build();
    }
}