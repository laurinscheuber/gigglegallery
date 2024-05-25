package ch.fhnw.webec.exercise.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class GiphyService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "ZoTL3Jdvlm5MyAn34B3nMDMw5BPBoZJh";
    private final String baseUrl = "https://api.giphy.com/v1/gifs";


    public Map<String, Object> searchGiphy(String query, int limit){
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/search")
                .queryParam("api_key", apiKey)
                .queryParam("q", query)
                .queryParam("limit", limit)
                .toUriString();
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getTrendingGifs(int limit){
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/trending")
                .queryParam("api_key", apiKey)
                .queryParam("limit",limit)
                .toUriString();
        return restTemplate.getForObject(url, Map.class);
    }



}
