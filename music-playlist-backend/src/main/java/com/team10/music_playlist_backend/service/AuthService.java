package com.team10.music_playlist_backend.service;

import com.team10.music_playlist_backend.dto.LoginResponse;
import com.team10.music_playlist_backend.entity.User;
import com.team10.music_playlist_backend.repository.UserRepository;
import com.team10.music_playlist_backend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User signup(String username, String fullname, String email, String password) {
        User user = User.builder()
                .username(username)
                .fullName(fullname)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        return userRepository.save(user);
    }

    public LoginResponse login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.generateAccessToken(email);

        return new LoginResponse(token, user);
    }

    public void logout(String accessToken) {
    }
}
