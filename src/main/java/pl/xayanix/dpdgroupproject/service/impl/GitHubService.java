package pl.xayanix.dpdgroupproject.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import pl.xayanix.dpdgroupproject.exception.ApiException;
import pl.xayanix.dpdgroupproject.model.*;
import pl.xayanix.dpdgroupproject.service.IGitHubService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService implements IGitHubService {

    private final WebClient webClient;

    @Autowired
    public GitHubService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.github.com").build();
    }

    public List<Repository> getUserRepositories(String username) {
        try {
            List<Repository> repositories = webClient.get()
                    .uri("/users/{username}/repos", username)
                    .retrieve()
                    .bodyToFlux(Repository.class)
                    .collectList()
                    .block();

            if (repositories == null || repositories.isEmpty()) {
                throw new ApiException(404, "User not found or no repositories");
            }

            return repositories.stream()
                    .filter(repo -> !repo.isFork())
                    .peek(repo -> repo.setBranches(getBranches(username, repo.getName())))
                    .collect(Collectors.toList());
        } catch (WebClientResponseException e) {
            throw new ApiException(e.getStatusCode().value(), e.getMessage());
        }

    }

    private List<Branch> getBranches(String username, String repoName) {
        return webClient.get()
                .uri("/repos/{username}/{repoName}/branches", username, repoName)
                .retrieve()
                .bodyToFlux(Branch.class)
                .collectList()
                .block();
    }
}
