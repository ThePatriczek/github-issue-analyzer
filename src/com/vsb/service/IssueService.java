package service;

import java.io.IOException;
import org.kohsuke.github.GHIssue;
import repository.GithubRepository;

public class IssueService {
    public GHIssue getIssue(final String owner, final String repo, final int id) throws IOException {
        final GithubRepository githubRepository = new GithubRepository(owner, repo);
        return githubRepository.getIssue(id);
    }
}
