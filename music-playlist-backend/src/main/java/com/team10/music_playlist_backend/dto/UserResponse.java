package com.team10.music_playlist_backend.dto;

import com.team10.music_playlist_backend.entity.User;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String residentialArea;
    private String selfIntroduction;
    private String profileImageUrl;

    public static UserResponse from(User u) {
        return UserResponse.builder()
                .id(u.getId())
                .username(u.getUsername())
                .email(u.getEmail())
                .fullName(u.getFullName())
                .residentialArea(u.getResidentialArea())
                .selfIntroduction(u.getSelfIntroduction())
                .profileImageUrl(u.getProfileImageUrl())
                .build();
    }
}