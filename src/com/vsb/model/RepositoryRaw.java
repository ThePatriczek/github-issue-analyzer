package model;

import java.io.IOException;
import java.util.List;
import repository.GithubRepository;

public class RepositoryRaw {
    final private String owner;
    final private String name;
    final private String description;
    final private String language;
    final private List<String> topics;
    final private int stars;

    public RepositoryRaw(String owner, String name, String description, String language, List<String> topics, int stars) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.language = language;
        this.topics = topics;
        this.stars = stars;
    }

    public RepositoryRaw(GithubRepository repo) throws IOException {
        this.owner = repo.getOwner();
        this.name = repo.getName();
        this.description = repo.getDescription();
        this.language = repo.getLanguage();
        this.topics = repo.getTopics();
        this.stars = repo.getStars();
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public List<String> getTopics() {
        return topics;
    }

        public int getStars() {
        return stars;
    }
}
