package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.service.AuthService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        User user = authService.signup(req.getUsername(), req.getFullname(), req.getEmail(), req.getPassword());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        User user = authService.login(req.getUsername(), req.getPassword());
        return ResponseEntity.ok(user);
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
        private String username;
        private String password;
    }
}
