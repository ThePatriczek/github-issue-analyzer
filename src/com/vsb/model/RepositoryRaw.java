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

    public RepositoryRaw(String owner, String name, String description, String language, List<String> topics) {
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.language = language;
        this.topics = topics;
    }

    public RepositoryRaw(GithubRepository repo) throws IOException {
        this.owner = repo.getOwner();
        this.name = repo.getName();
        this.description = repo.getDescription();
        this.language = repo.getLanguage();
        this.topics = repo.getTopics();
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
}
