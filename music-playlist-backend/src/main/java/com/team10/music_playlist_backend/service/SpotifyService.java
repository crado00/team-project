package com.team10.music_playlist_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import com.team10.music_playlist_backend.dto.SongCharacteristicResponse;
import com.team10.music_playlist_backend.dto.SongDetailsResponse;
import com.team10.music_playlist_backend.dto.SongLyricsResponse;

@Service
public class SpotifyService {

    @Value("${spotify.client-id}")
    private String clientId;

    @Value("${spotify.client-secret}")
    private String clientSecret;

    private final WebClient webClient = WebClient.create();

    private String getAccessToken() {
        String auth = Base64.getEncoder()
                .encodeToString((clientId + ":" + clientSecret).getBytes(StandardCharsets.UTF_8));

        Map<String, Object> response = webClient.post()
                .uri("https://accounts.spotify.com/api/token")
                .header("Authorization", "Basic " + auth)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("grant_type=client_credentials")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (response == null || !response.containsKey("access_token")) {
            throw new IllegalStateException("Spotify access token 발급 실패");
        }
        return (String) response.get("access_token");
    }

    public Map<String, Object> searchTrack(String query) {
        String token = getAccessToken();
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);

        return webClient.get()
                .uri("https://api.spotify.com/v1/search?q=" + encodedQuery + "&type=track&market=KR&limit=10")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    public SongDetailsResponse getSongDetails(String trackId) {
        String token = getAccessToken();

        Map<String, Object> track = webClient.get()
                .uri("https://api.spotify.com/v1/tracks/{id}?market=KR", trackId)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (track == null) throw new IllegalStateException("트랙 정보를 가져오지 못했습니다.");

        String id = (String) track.get("id");
        String name = (String) track.get("name");

        String singer = "";
        Object artistsObj = track.get("artists");
        if (artistsObj instanceof List<?> artists) {
            singer = artists.stream()
                    .filter(Map.class::isInstance)
                    .map(a -> (String) ((Map<?, ?>) a).get("name"))
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");
        }

        String explanation = null;
        LocalDate releaseDate = null;
        Object albumObj = track.get("album");
        if (albumObj instanceof Map<?, ?> album) {
            explanation = (String) album.get("name");
            String rd = (String) album.get("release_date"); // yyyy | yyyy-MM | yyyy-MM-dd
            releaseDate = parseReleaseDate(rd);
        }

        return SongDetailsResponse.builder()
                .id(id)
                .name(name)
                .singer(singer)
                .explanation(explanation)
                .releaseDate(releaseDate)
                .build();
    }

    public SongCharacteristicResponse getSongCharacteristic(String trackId) {
        String token = getAccessToken();

        Map<String, Object> feat = webClient.get()
                .uri("https://api.spotify.com/v1/audio-features/{id}", trackId)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (feat == null) throw new IllegalStateException("오디오 특성을 가져오지 못했습니다.");

        Integer bpm = null;
        Object tempoObj = feat.get("tempo");
        if (tempoObj instanceof Number n) {
            bpm = Math.toIntExact(Math.round(n.doubleValue()));
        }

        String keyStr = null;
        Object keyObj = feat.get("key");
        Object modeObj = feat.get("mode");
        if (keyObj instanceof Number k && modeObj instanceof Number md) {
            keyStr = toKeyName(k.intValue(), md.intValue());
        }

        return SongCharacteristicResponse.builder()
                .bpm(bpm)
                .key(keyStr)
                .build();
    }

    private LocalDate parseReleaseDate(String s) {
        if (s == null) return null;
        try {
            if (s.length() == 10) return LocalDate.parse(s);
            if (s.length() == 7)  return LocalDate.parse(s + "-01");
            if (s.length() == 4)  return LocalDate.parse(s + "-01-01");
        } catch (Exception ignored) {}
        return null;
    }

    private String toKeyName(int key, int mode) {
        String[] KEYS = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
        if (key < 0 || key > 11) return null;
        String base = KEYS[key];
        boolean isMinor = (mode == 0);
        return isMinor ? base + "m" : base;
    }
}