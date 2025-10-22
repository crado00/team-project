package com.team10.music_playlist_backend.controller;

import com.team10.music_playlist_backend.dto.LoginResponse;
import com.team10.music_playlist_backend.dto.UserResponse;
import com.team10.music_playlist_backend.service.AuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        authService.signup(req.username, req.fullname, req.email, req.password);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        LoginResponse loginResponse = authService.login(req.getEmail(), req.getPassword());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String accessToken) {
        authService.logout(accessToken);
        return ResponseEntity.ok("로그아웃 완료");
    }

    @Data
    static class SignupRequest {
        private String username;
        private String fullname;
        private String email;
        private String password;
    }

    @Data
    static class LoginRequest {
        private String email;
        private String password;
    }

    @Data
    static class JwtResponse {
        private final String accessToken;
        private final UserResponse user;
    }
}