package pl.xayanix.dpdgroupproject.service;

import pl.xayanix.dpdgroupproject.model.Repository;

import java.util.List;


public interface IGitHubService {

	List<Repository> getUserRepositories(String username);

}
