package com.example.backend.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PlaylistResponse {
    private Long id;
    private String name;
    private String description;
    private String coverImageUrl;
    private String creatorName;
    //  private List<MusicResponse> songs;
}