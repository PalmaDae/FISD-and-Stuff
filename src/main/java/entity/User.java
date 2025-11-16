package entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {
    private long id;
    private String username;
    private String hashPassword;
    private Role role;
    private List<Charakter> charakters = new ArrayList<>();

    public User(long id, String username, String hashPassword, Role role) {
        this.id = id;
        this.username = username;
        this.hashPassword = hashPassword;
        this.role = role;
    }

    public void addCharakter(Charakter charakter) throws SQLException {
        charakters.add(charakter);
    }

}
