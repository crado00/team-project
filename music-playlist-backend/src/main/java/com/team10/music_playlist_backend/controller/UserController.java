package com.team10.music_playlist_backend.controller;

import com.team10.music_playlist_backend.dto.UserResponse;
import com.team10.music_playlist_backend.dto.UserUpdateRequest;
import com.team10.music_playlist_backend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> get(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> update(@PathVariable Long userId,
                                               @Valid @RequestBody UserUpdateRequest req) {
        return ResponseEntity.ok(userService.updateUser(userId, req));
    }
}