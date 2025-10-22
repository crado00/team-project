package com.team10.music_playlist_backend.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SongLyricsResponse {
    private String id;
    private String name;
    private String lyrics;
}