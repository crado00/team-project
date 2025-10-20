package com.example.backend.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PlaylistRequest {
    private String name;
    private String description;
    private String coverImageUrl;
    //  private List<MusicResponse> songs;
}