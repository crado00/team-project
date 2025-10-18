package com.example.backend.controller;

import com.example.backend.dto.*;
import com.example.backend.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
@RequiredArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;

    @PostMapping("/{userId}")
    public ResponseEntity<PlaylistResponse> createPlaylist(
            @PathVariable Long userId,
            @RequestBody PlaylistRequest request) {
        return ResponseEntity.ok(playlistService.createPlaylist(userId, request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PlaylistResponse>> getUserPlaylists(@PathVariable Long userId) {
        return ResponseEntity.ok(playlistService.getUserPlaylists(userId));
    }

    @GetMapping("/{playlistId}")
    public ResponseEntity<PlaylistResponse> getPlaylist(@PathVariable Long playlistId) {
        return ResponseEntity.ok(playlistService.getPlaylist(playlistId));
    }

    @DeleteMapping("/{playlistId}/user/{userId}")
    public ResponseEntity<?> deletePlaylist(@PathVariable Long playlistId, @PathVariable Long userId) {
        playlistService.deletePlaylist(playlistId, userId);
        return ResponseEntity.ok("플레이리스트 삭제 완료");
    }
}
