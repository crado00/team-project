package com.team10.music_playlist_backend.controller;

import com.team10.music_playlist_backend.dto.SongCharacteristicResponse;
import com.team10.music_playlist_backend.dto.SongDetailsResponse;
import com.team10.music_playlist_backend.dto.SongLyricsResponse;
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

    @GetMapping("/characteristic/{songId}")
    public ResponseEntity<SongCharacteristicResponse> getSongCharacteristic(@PathVariable Long songId){
        return ResponseEntity.ok(musicService.getSongCharacteristic(songId));
    }

    @GetMapping("/information/{songId}")
    public ResponseEntity<SongLyricsResponse> getSongLyrics(@PathVariable Long songId){
        return ResponseEntity.ok(musicService.getSongLyrics(songId));
    }
}