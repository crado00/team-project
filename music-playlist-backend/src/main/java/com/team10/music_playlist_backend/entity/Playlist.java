package com.team10.music_playlist_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Postgres 시퀀스 자동 생성
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PlaylistMusic> playlistMusics = new ArrayList<>();
//
//    public void addPlaylistMusic(PlaylistMusic playlistMusic) {
//        playlistMusics.add(playlistMusic);
//        playlistMusic.setPlaylist(this);
//    }
//
//    public void removePlaylistMusic(PlaylistMusic playlistMusic) {
//        playlistMusics.remove(playlistMusic);
//        playlistMusic.setPlaylist(null);
//    }
}
