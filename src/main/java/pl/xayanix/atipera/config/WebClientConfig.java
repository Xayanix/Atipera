package pl.xayanix.atipera.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${github.token}")
    private String githubToken;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().defaultHeader("Authorization", "Bearer " + githubToken);
    }
}
