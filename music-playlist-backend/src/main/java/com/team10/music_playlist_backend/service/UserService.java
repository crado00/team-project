package com.team10.music_playlist_backend.service;

import com.team10.music_playlist_backend.dto.UserResponse;
import com.team10.music_playlist_backend.dto.UserUpdateRequest;
import com.team10.music_playlist_backend.entity.User;
import com.team10.music_playlist_backend.exception.ResourceNotFoundException;
import com.team10.music_playlist_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse getUser(Long id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("사용자를 찾을 수 없습니다."));
        return UserResponse.from(u);
    }

    @Transactional
    public UserResponse updateUser(Long id, UserUpdateRequest req) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("사용자를 찾을 수 없습니다."));

        if (userRepository.existsByUsernameAndIdNot(req.getUsername(), id)) {
            throw new IllegalArgumentException("이미 사용 중인 닉네임입니다.");
        }

        u.setUsername(req.getUsername());
        u.setFullName(req.getFullName());
        u.setResidentialArea(req.getResidentialArea());
        u.setSelfIntroduction(req.getSelfIntroduction());
        u.setProfileImageUrl(req.getProfileImageUrl());

        return UserResponse.from(u);
    }
}