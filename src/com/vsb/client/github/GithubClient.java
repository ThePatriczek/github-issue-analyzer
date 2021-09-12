package com.vsb.client.github;

import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class GithubClient {
    GitHub github;

    public GithubClient() throws IOException {
        String token = "49223e6c31128bbf667709e5b405cf7551bae9b3";
        github = new GitHubBuilder().withOAuthToken(token).build();
    }
}
