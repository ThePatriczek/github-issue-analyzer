package client.github;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.PagedSearchIterable;

import java.io.IOException;

public class GithubClient {
        final public GitHub github;

    public GithubClient() throws IOException {
        String token = "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"; //? https://github.com/thepatriczek personal read-only token
        github = new GitHubBuilder().withOAuthToken(token).build();
    }

    public PagedSearchIterable<GHUser> searchUsers(final String query) throws IOException {
        return github.searchUsers().q(query).list();
    }
}
