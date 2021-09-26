package model;

public class User {
    final private String login;
    final private String name;
    final private String avatarUrl;

    public User(String login, String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }
}
