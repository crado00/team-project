package com.team10.music_playlist_backend.controller;

import com.team10.music_playlist_backend.dto.SongCharacteristicResponse;
import com.team10.music_playlist_backend.dto.SongDetailsResponse;
import com.team10.music_playlist_backend.service.SpotifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class MusicController {

    private final SpotifyService spotifyService;

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> search(@RequestParam String query) {
        return ResponseEntity.ok(spotifyService.searchTrack(query));
    }

    @GetMapping("/details/{songId}")
    public ResponseEntity<SongDetailsResponse> getSongDetails(@PathVariable String songId) {
        return ResponseEntity.ok(spotifyService.getSongDetails(songId));
    }

    @GetMapping("/characteristic/{songId}")
    public ResponseEntity<SongCharacteristicResponse> getSongCharacteristic(@PathVariable String songId) {
        return ResponseEntity.ok(spotifyService.getSongCharacteristic(songId));
    }

}