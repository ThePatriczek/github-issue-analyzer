package service;

import org.kohsuke.github.GHUser;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedSearchIterable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import client.github.GithubClient;
import model.Repository;
import model.User;
import repository.UserRepository;

public class UserService {
    public List<User> search(final String query) throws IOException {
        final PagedSearchIterable<GHUser> searchedUsers = new GithubClient().searchUsers(query);

        final List<User> users = new ArrayList<User>();

        for (GHUser searchedUser : searchedUsers) {
            String login = searchedUser.getLogin();
            String name = searchedUser.getName();
            String avatarUrl = searchedUser.getAvatarUrl();
            final User user = new User(login, name, avatarUrl);
            users.add(user);
        }

        return users;
    }

    public List<Repository> getRepositories(final String login) throws IOException {
        final Map<String, GHRepository> repositoriesMap = new UserRepository(login).getRepositories();
        
        List<Repository> repositories = new ArrayList<>();
        repositoriesMap.forEach((k, v) -> {
            String name = v.getName();
            String description = v.getDescription();
            String language = v.getLanguage();
            int stars = v.getStargazersCount();
            Repository repository = new Repository(name, description, language,stars);
            repositories.add(repository);
        });

        return repositories;
    }
}
