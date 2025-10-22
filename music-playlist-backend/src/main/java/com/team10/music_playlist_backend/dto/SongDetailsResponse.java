package com.team10.music_playlist_backend.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SongDetailsResponse {
    private String id;
    private String name;
    private String singer;
    private String explanation;
    private LocalDate releaseDate;
}