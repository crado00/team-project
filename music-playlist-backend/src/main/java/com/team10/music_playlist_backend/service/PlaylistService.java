package com.team10.music_playlist_backend.service;

import com.team10.music_playlist_backend.dto.*;
import com.team10.music_playlist_backend.entity.*;
import com.team10.music_playlist_backend.exception.ResourceNotFoundException;
import com.team10.music_playlist_backend.repository.*;
import com.team10.music_playlist_backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;

//    @Transactional
//    public PlaylistResponse createPlaylist(Long userId, PlaylistRequest request) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("사용자를 찾을 수 없습니다."));
//
//        Playlist playlist = Playlist.builder()
//                .title(request.getTitle())
//                .explanation(request.getExplanation())
//                .imageUrl(request.getImageUrl())
//                .user(user)
//                .build();
//
////        if (request.getMusics() != null) {
////            request.getMusics().forEach(musicDto -> {
////                Music music = Music.builder()
////                        .title(musicDto.getTitle())
////                        .artist(musicDto.getArtist())
////                        .album(musicDto.getAlbum())
////                        .genre(musicDto.getGenre())
////                        .duration(musicDto.getDuration())
////                        .youtubeUrl(musicDto.getYoutubeUrl())
////                        .playlist(playlist)
////                        .build();
////                playlist.getMusics().add(music);
////            });
////        }
//
//        playlistRepository.save(playlist);
//        return mapToResponse(playlist);
//    }
//
//    public List<PlaylistResponse> getUserPlaylists(Long userId) {
//        List<Playlist> playlists = playlistRepository.findByUserId(userId);
//        return playlists.stream().map(this::mapToResponse).collect(Collectors.toList());
//    }
//
//    public PlaylistResponse getPlaylist(Long playlistId) {
//        Playlist playlist = playlistRepository.findById(playlistId)
//                .orElseThrow(() -> new ResourceNotFoundException("플레이리스트를 찾을 수 없습니다."));
//        return mapToResponse(playlist);
//    }

    @Transactional
    public void deletePlaylist(Long playlistId, String userId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("플레이리스트를 찾을 수 없습니다."));
        if (!playlist.getUser().getId().equals(userId)) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }
        playlistRepository.delete(playlist);
    }

//    private PlaylistResponse mapToResponse(Playlist playlist) {
//        List<MusicResponse> MusicResponses = playlist.getMusics().stream()
//                .map(music -> new MusicResponse(
//                        music.getTitle(),
//                        music.getArtist(),
//                        music.getAlbum(),
//                        music.getGenre(),
//                        music.getDuration(),
//                        music.getYoutubeUrl()))
//                .collect(Collectors.toList());
//
//        return new PlaylistResponse(
//                playlist.getId(),
//                playlist.getTitle(),
//                playlist.getExplanation(),
//                playlist.getImageUrl(),
//                MusicResponses
//        );
//    }

    @Transactional
    public Playlist editPlaylist(Long playlistId, PlaylistEditRequest request, String userId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("플레이리스트를 찾을 수 없습니다."));

        // 본인 소유 확인
//        if (!playlist.getOwner().getId().equals(userId)) {
//            throw new UnauthorizedException("이 플레이리스트를 수정할 권한이 없습니다.");
//        }

        if (request.getTitle() != null && !request.getTitle().isBlank()) {
            playlist.setTitle(request.getTitle());
        }

        if (request.getExplanation() != null) {
            playlist.setExplanation(request.getExplanation());
        }

//        if (request.getMusicIds() != null && !request.getMusicIds().isEmpty()) {
//            List<Music> musics = musicRepository.findAllById(request.getMusicIds());
//
//            Map<Long, Music> musicMap = musics.stream()
//                    .collect(Collectors.toMap(Music::getId, s -> s));
//
//            List<Music> orderedMusics = request.getMusicIds().stream()
//                    .map(musicMap::get)
//                    .filter(Objects::nonNull)
//                    .collect(Collectors.toList());
//
//            playlist.getPlayListMusics().clear();
//
//            long seq = 1;
//            for (Music music : orderedMusics) {
//                PlayListMusic ps = PlayListMusic.builder()
//                        .playlist(playlist)
//                        .music(music)
//                        .sequence(seq++)
//                        .build();
//
//                playlist.getPlayListMusics().add(ps);
//            }
//        }

        return playlistRepository.save(playlist);
    }

    public Playlist getPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    @Transactional
    public void removeMusicFromPlaylist(Long playlistId, Long musicId, String username) {
        Playlist playList = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new ResourceNotFoundException("플레이리스트를 찾을 수 없습니다."));

        // 자신이 만든 플레이리스트인지 확인
        if (!playList.getUser().getUsername().equals(username)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "이 플레이리스트를 수정할 권한이 없습니다.");
        }

//        Music music = musicRepository.findById(musicId)
//                .orElseThrow(() -> new ResourceNotFoundException("음악을 찾을 수 없습니다."));
//
//        playList.getMusics().remove(music);
        playlistRepository.save(playList);
    }


}