package com.team10.music_playlist_backend.repository;

import com.team10.music_playlist_backend.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {}