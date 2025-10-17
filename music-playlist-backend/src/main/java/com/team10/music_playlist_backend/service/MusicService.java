package com.team10.music_playlist_backend.service;

import com.team10.music_playlist_backend.dto.SongDetailsResponse;
import com.team10.music_playlist_backend.entity.Music;
import com.team10.music_playlist_backend.exception.ResourceNotFoundException;
import com.team10.music_playlist_backend.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    @Transactional(readOnly = true)
    public SongDetailsResponse getSongDetails(Long songId){
        Music m = musicRepository.findById(songId)
                .orElseThrow(() -> new ResourceNotFoundException("해당 곡을 찾을 수 없습니다."));
        return SongDetailsResponse.from(m);
    }
}