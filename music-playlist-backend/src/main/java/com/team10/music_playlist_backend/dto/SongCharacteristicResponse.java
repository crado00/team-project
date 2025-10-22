package com.team10.music_playlist_backend.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SongCharacteristicResponse {
    private Integer bpm;
    private String key;
}