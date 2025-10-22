package com.team10.music_playlist_backend.dto;

import com.team10.music_playlist_backend.entity.Playlist;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistResponse {
    private Long id;
    private String title;
    private String explanation;
    private String imageUrl;
    //private List<MusicResponse> musics;

    public static PlaylistResponse fromEntity(Playlist playlist) {
        return PlaylistResponse.builder()
                .id(playlist.getId())
                .title(playlist.getTitle())
                .explanation(playlist.getExplanation())
                .imageUrl(playlist.getImageUrl())
//                .musics(playlist.getPlaylistMusics().stream()
//                        .sorted((a, b) -> Long.compare(a.getSequence(), b.getSequence()))
//                        .map(ps -> MusicResponse.fromEntity(ps.getMusic(), ps.getSequence()))
//                        .collect(Collectors.toList()))
                .build();
    }
}
