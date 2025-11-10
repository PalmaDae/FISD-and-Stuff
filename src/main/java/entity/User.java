package entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
    private long id;
    private String username;
    private String hashPassword;
    private Role role;
    private List<Long> charaktersIds = new ArrayList<>();

    public User(long id, String username, String hashPassword, Role role, List<Long> charaktersIds) {
        this.id = id;
        this.username = username;
        this.hashPassword = hashPassword;
        this.role = role;
        this.charaktersIds = charaktersIds;
    }
}
