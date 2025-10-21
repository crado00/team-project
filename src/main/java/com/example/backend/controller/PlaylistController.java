package com.example.backend.controller;

import com.example.backend.dto.PlaylistEditRequest;
import com.example.backend.dto.PlaylistResponse;
import com.example.backend.entity.Playlist;
import com.example.backend.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    @PutMapping("/{playlistId}/edit")
    public ResponseEntity<PlaylistResponse> editPlaylist(
            @PathVariable Long playlistId,
            @RequestBody PlaylistEditRequest request,
            @AuthenticationPrincipal UserPrincipal userPrincipal) {

        Playlist playlist = playlistService.editPlaylist(
                playlistId,
                request,
                userPrincipal.getName()
        );

        return ResponseEntity.ok(PlaylistResponse.fromEntity(playlist));
    }


    @GetMapping("/{playlistId}")
    public ResponseEntity<PlaylistResponse> getPlaylistById(@PathVariable Long playlistId) {
        Playlist playlist = playlistService.getPlaylistById(playlistId);
        return ResponseEntity.ok(PlaylistResponse.fromEntity(playlist));
    }


    @DeleteMapping("/{playlistId}")
    public ResponseEntity<Void> deletePlaylist(
            @PathVariable Long playlistId,
            @AuthenticationPrincipal UserPrincipal userPrincipal) {

        playlistService.deletePlaylist(playlistId, userPrincipal.getName());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{playlistId}/musics/{musicId}")
    public ResponseEntity<Void> removeMusicFromPlayList(
            @PathVariable Long playlistId,
            @PathVariable Long musicId,
            @AuthenticationPrincipal(expression = "username") String username) {

        playlistService.removeMusicFromPlaylist(playlistId, musicId, username);
        return ResponseEntity.noContent().build();
    }
}
