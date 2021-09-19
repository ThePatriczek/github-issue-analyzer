package dto;

public class Repository {
    final private String name;
    final private String description;
    final private String language;
    final private int stars;

    public Repository(String name, String description, String language, int stars) {
        this.name = name;
        this.description = description;
        this.language = language;
        this.stars = stars;
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

    public int getStars() {
        return stars;
    }
}
