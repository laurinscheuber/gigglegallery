package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.service.GiphyService;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GiphyController {

    private final GiphyService giphyService;


    public GiphyController(GiphyService giphyService) {
        this.giphyService = giphyService;
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

    @GetMapping("/trending_gifs")
    public ResponseEntity<Map<String, Object>> getTrendingGifs(@RequestParam(defaultValue = "10") int limit) {
        try {
            Map<String, Object> response = giphyService.getTrendingGifs(limit);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = Map.of("error", e.getMessage());
            return ResponseEntity.status(500).body((Map) errorResponse);
        }
    }

}
