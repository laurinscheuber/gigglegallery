package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.service.GiphyService;
import ch.fhnw.webec.exercise.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
public class GiphyController {

    private final GiphyService giphyService;
    private final UserService userService;


    public GiphyController(GiphyService giphyService, UserService userService) {
        this.giphyService = giphyService;
        this.userService = userService;
    }

    @GetMapping("/search_gifs")
    public ResponseEntity<Map<String, Object>> searchGifs(@RequestParam String query, @RequestParam(defaultValue = "10") int limit) {
        try {
            Map<String, Object> response = giphyService.searchGiphy(query, limit);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = Map.of("error", e.getMessage());
            return ResponseEntity.status(500).body((Map) errorResponse);
        }
    }

    @PostMapping("/api/users/me/favoriteGif")
    public ResponseEntity<Map<String, Object>> saveFavoriteGif(@RequestBody Map<String, String> request) {
        try {
            String favoriteGif = request.get("favoriteGif");
            Long userId = userService.getUserId();
            userService.saveFavoriteGif(userId, favoriteGif);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Favorite GIF saved successfully");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, String> errorResponse = Map.of("error", e.getMessage());
            return ResponseEntity.status(500).body((Map) errorResponse);
        }
    }
}
