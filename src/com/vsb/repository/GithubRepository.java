package repository;

import org.kohsuke.github.*;
import java.io.IOException;
import java.util.List;
import client.github.GithubClient;

public class GithubRepository {
    final GithubClient githubClient = new GithubClient();
    final GHRepository repository;

    public GithubRepository(final String name) throws IOException {
        repository = githubClient.github.getRepository(name);
    }

    public String getLanguage() {
        return repository.getLanguage();
    }

    public GHIssue getIssue(final int id) throws IOException {
        return repository.getIssue(id);
    }

    public List<GHIssue> getIssues() throws IOException {
        return repository.getIssues(GHIssueState.ALL);
    }

    public List<GHIssue> getIssues(final GHIssueState state) throws IOException {
        return repository.getIssues(state);
    }

    public List<String> getTopics() throws IOException {
        return repository.listTopics();
    }

    public PagedIterable<GHLabel> getLabels() throws IOException {
        return repository.listLabels();
    }
}
