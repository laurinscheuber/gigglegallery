package ch.fhnw.webec.exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GiphyConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public boolean getApiKey() {
        return true;
    }
}
