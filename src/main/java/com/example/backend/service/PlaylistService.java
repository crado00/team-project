package com.example.backend.service;

import com.example.backend.dto.*;
import com.example.backend.entity.*;
import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;

    @Transactional
    public PlaylistResponse createPlaylist(Long userId, PlaylistRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("사용자를 찾을 수 없습니다."));

        Playlist playlist = Playlist.builder()
                .name(request.getName())
                .description(request.getDescription())
                .coverImageUrl(request.getCoverImageUrl())
                .user(user)
                .build();

//        if (request.getMusics() != null) {
//            request.getMusics().forEach(songDto -> {
//                Music music = Music.builder()
//                        .title(songDto.getTitle())
//                        .artist(songDto.getArtist())
//                        .album(songDto.getAlbum())
//                        .genre(songDto.getGenre())
//                        .duration(songDto.getDuration())
//                        .youtubeUrl(songDto.getYoutubeUrl())
//                        .playlist(playlist)
//                        .build();
//                playlist.getMusics().add(song);
//            });
//        }

        playlistRepository.save(playlist);
        return mapToResponse(playlist);
    }

    public List<PlaylistResponse> getUserPlaylists(Long userId) {
        List<Playlist> playlists = playlistRepository.findByUserId(userId);
        return playlists.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public PlaylistResponse getPlaylist(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("플레이리스트를 찾을 수 없습니다."));
        return mapToResponse(playlist);
    }

    @Transactional
    public void deletePlaylist(Long playlistId, Long userId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("플레이리스트를 찾을 수 없습니다."));
        if (!playlist.getUser().getId().equals(userId)) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }
        playlistRepository.delete(playlist);
    }

//    private PlaylistResponse mapToResponse(Playlist playlist) {
//        List<MusicResponse> MusicResponses = playlist.getMusics().stream()
//                .map(song -> new MusicResponse(
//                        song.getTitle(),
//                        song.getArtist(),
//                        song.getAlbum(),
//                        song.getGenre(),
//                        song.getDuration(),
//                        song.getYoutubeUrl()))
//                .collect(Collectors.toList());

        return new PlaylistResponse(
                playlist.getId(),
                playlist.getName(),
                playlist.getDescription(),
                playlist.getCoverImageUrl(),
                playlist.getUser().getNickname(),
                MusicResponses
        );
    }
}
