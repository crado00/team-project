package com.team10.music_playlist_backend.dto;

import com.team10.music_playlist_backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String accessToken;
    private UserDto user;

    public LoginResponse(String accessToken, User user) {
        this.accessToken = accessToken;
        this.user = new UserDto(user);
    }

}
