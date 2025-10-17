package com.team10.music_playlist_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Long id;

    @Column(name = "song_name", nullable = false)
    private String name;

    @Column(name = "singer")
    private String singer;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "release_date")
    private LocalDate releaseDate;
}