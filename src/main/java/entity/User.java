package entity;

public class User {
    private long id;
    private String username;
    private String hashPassword;
    private Role role;

    public User(long id, String username, String hashPassword, Role role) {
        this.id = id;
        this.username = username;
        this.hashPassword = hashPassword;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public Role getRole() {
        return role;
    }
}
