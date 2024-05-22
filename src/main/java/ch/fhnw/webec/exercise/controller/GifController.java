package ch.fhnw.webec.exercise.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GifController {

    @Value("${giphy.api.key}")
    private String giphyApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/api/randomGif")
    public String getRandomGif() {
        String url = "https://api.giphy.com/v1/gifs/random?api_key=" + giphyApiKey;
        return restTemplate.getForObject(url, String.class);
    }
}