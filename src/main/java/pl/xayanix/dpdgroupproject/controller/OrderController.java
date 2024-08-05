/**
 * Controller class for handling HTTP requests related to orders.
 * Responsible for receiving and processing orders, as well as updating existing orders.
 */
package pl.xayanix.dpdgroupproject.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.xayanix.dpdgroupproject.model.Repository;
import pl.xayanix.dpdgroupproject.service.IGitHubService;

import java.util.List;


@RestController
@RequestMapping("/api/github")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OrderController {

	IGitHubService gitHubService;

	/**
	 * Endpoint for listing the repositories of a specific GitHub user.
	 *
	 * @param username the GitHub username to retrieve repositories for
	 * @param acceptHeader the value of the Accept header in the request
	 * @return a ResponseEntity containing a list of repositories or an appropriate HTTP status
	 */

	@GetMapping("/users/{username}/repos")
	public ResponseEntity<List<Repository>> listUserRepositories(@PathVariable String username, @RequestHeader(HttpHeaders.ACCEPT) String acceptHeader) {
		if (!"application/json".equals(acceptHeader)) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

		List<Repository> repositories = gitHubService.getUserRepositories(username);
		return ResponseEntity.ok(repositories);
	}
}
