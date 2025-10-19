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
    private Long userId;

    @Column(name = "explanation", columnDefinition = "TEXT")
    private String explanation;
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "imageUrl")
    private String imageUrl;
}
