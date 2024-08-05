package pl.xayanix.atipera.service;

import pl.xayanix.atipera.model.Repository;

import java.util.List;


public interface IGitHubService {

	List<Repository> getUserRepositories(String username);

}
