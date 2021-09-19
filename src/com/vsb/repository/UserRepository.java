package repository;

import org.kohsuke.github.*;
import java.io.IOException;
import java.util.Map;

import client.github.GithubClient;

public class UserRepository {
    final GithubClient githubClient = new GithubClient();
    final GHUser user;


    public UserRepository(final String login) throws IOException  {
         user = githubClient.github.getUser(login);
    }

    public Map<String, GHRepository> getRepositories() throws IOException {
        return user.getRepositories();
    }
}
