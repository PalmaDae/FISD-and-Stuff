package FifthHomeWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataClass {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/beerfest", "postgres","010909");
    }
}
