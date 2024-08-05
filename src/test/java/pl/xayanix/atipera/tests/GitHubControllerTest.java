package pl.xayanix.atipera.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.xayanix.atipera.controller.GitHubController;
import pl.xayanix.atipera.model.GitHubUser;
import pl.xayanix.atipera.model.Repository;
import pl.xayanix.atipera.service.IGitHubService;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(GitHubController.class)
public class GitHubControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IGitHubService gitHubService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListUserRepositories_ValidAcceptHeader() throws Exception {
        String username = "validUser";
        Repository repo = new Repository("repo1", new GitHubUser("owner"), Lists.newArrayList(), false);
        when(gitHubService.getUserRepositories(anyString())).thenReturn(List.of(repo));

        mockMvc.perform(get("/api/github/users/{username}/repos", username)
                .header(HttpHeaders.ACCEPT, "application/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(repo))));
    }

    @Test
    public void testListUserRepositories_InvalidAcceptHeader() throws Exception {
        String username = "validUser";
        mockMvc.perform(get("/api/github/users/{username}/repos", username)
                .header(HttpHeaders.ACCEPT, "text/plain"))
                .andExpect(status().isNotAcceptable());
    }

}
