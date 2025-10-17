package com.team10.music_playlist_backend.dto;

import com.team10.music_playlist_backend.entity.Music;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class SongDetailsResponse {
    private Long id;
    private String name;
    private String singer;
    private String explanation;
    private LocalDate releaseDate;

    public static SongDetailsResponse from(Music m){
        return SongDetailsResponse.builder()
                .id(m.getId())
                .name(m.getName())
                .singer(m.getSinger())
                .explanation(m.getExplanation())
                .releaseDate(m.getReleaseDate())
                .build();
    }
}