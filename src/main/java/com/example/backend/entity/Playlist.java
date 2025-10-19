package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Long id;

    @Column(name = "playlist_user_id", nullable = false)
    private Long userId; // 소유자 ID

    @Column(name = "explanation", columnDefinition = "TEXT")
    private String explanation; // 설명

    @Column(name = "title", nullable = false)
    private String title; // 제목

    @Column(name = "imageUrl")
    private String imageUrl; // 이미지 URL
}
