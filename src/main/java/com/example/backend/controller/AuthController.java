package com.example.backend.controller;

import com.example.backend.service.AuthService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        authService.signup(req.username, req.password);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        String token = authService.login(req.username, req.password);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    // 로그아웃 API는 JWT 구조상 필요 없음.
    // 프론트에서 토큰을 삭제하면 로그아웃됨.

    @Data
    static class SignupRequest { String username; String password; }
    @Data
    static class LoginRequest { String username; String password; }
    @Data
    static class JwtResponse { final String token; }
}