package com.example.backend.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequest {
    private String residentialArea;
    private String selfIntroduction;
    private String profileImageUrl;
}
