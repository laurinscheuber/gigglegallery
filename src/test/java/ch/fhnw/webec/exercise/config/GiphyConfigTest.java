package ch.fhnw.webec.exercise.config;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GiphyConfigTest {

    @Test
    public void testGetGiphyConfig() {
        GiphyConfig giphyConfig = new GiphyConfig();
        assertThat(giphyConfig.getApiKey()).isNotNull();
    }
}