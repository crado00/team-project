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
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String selfIntroduction;
    private String residentialArea;
    private String profileImageUrl;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.selfIntroduction = user.getSelfIntroduction();
        this.residentialArea = user.getResidentialArea();
        this.profileImageUrl = user.getProfileImageUrl();
    }

}
