package com.team10.music_playlist_backend.dto;

import com.team10.music_playlist_backend.entity.Music;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SongLyricsResponse {
    private Long id;
    private String name;
    private String lyrics;

    public static SongLyricsResponse from(Music m){
        return SongLyricsResponse.builder()
                .id(m.getId())
                .name(m.getName())
                .lyrics(m.getLyrics())
                .build();
    }
}