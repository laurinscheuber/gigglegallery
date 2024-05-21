package ch.fhnw.webec.exercise.controller;

import ch.fhnw.webec.exercise.service.GiphyService;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GiphyController {

    private GiphyService giphyService;

    @GetMapping("/search_gifs")
    public Map<String, Object> searchGifs(@RequestParam String query, @RequestParam(defaultValue = "10") int limit){
        return giphyService.searchGiphy(query, limit);
    }
    @GetMapping("/trending_gifs")
    public Map<String, Object> getTrendingGifs(@RequestParam(defaultValue = "10")int limit){
        return giphyService.getTrendingGifs(limit);
    }


}
