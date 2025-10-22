package com.team10.music_playlist_backend.repository;

import com.team10.music_playlist_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsernameAndIdNot(String username, Long id);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}