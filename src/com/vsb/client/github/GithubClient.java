package com.vsb.client.github;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class GithubClient {
    final public GitHub github;

    public GithubClient() throws IOException {
        String token = "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"; //? https://github.com/thepatriczek personal read-only token
        github = new GitHubBuilder().withOAuthToken(token).build();
    }
}
