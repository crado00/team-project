package com.team10.music_playlist_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class UserUpdateRequest {

    @NotBlank(message = "닉네임(username)은 필수입니다.")
    private String username;

    private String fullName;
    private String residentialArea;
    private String selfIntroduction;
    private String profileImageUrl;
}