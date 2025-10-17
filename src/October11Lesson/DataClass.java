package October11Lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataClass {
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("localhost:5432/test", "postgres","");
    }
}
