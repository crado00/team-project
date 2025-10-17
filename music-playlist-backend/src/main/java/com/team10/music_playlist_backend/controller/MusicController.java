package com.team10.music_playlist_backend.controller;

import com.team10.music_playlist_backend.dto.SongDetailsResponse;
import com.team10.music_playlist_backend.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/details/{songId}")
    public ResponseEntity<SongDetailsResponse> getSongDetails(@PathVariable Long songId){
        return ResponseEntity.ok(musicService.getSongDetails(songId));
    }

}