package com.team10.music_playlist_backend.dto;

import com.team10.music_playlist_backend.entity.Music;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SongCharacteristicResponse {
    private Integer bpm;
    private String key;

    public static SongCharacteristicResponse from(Music m){
        return SongCharacteristicResponse.builder()
                .bpm(m.getBpm())
                .key(m.getKey())
                .build();
    }
}