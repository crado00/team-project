package com.example.backend.dto;

import com.example.backend.entity.User;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserRequest {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String residentialArea;
    private String selfIntroduction;
    private String profileImageUrl;

    public static UserRequest from(User u) {
        return UserRequest.builder()
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