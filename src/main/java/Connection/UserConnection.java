package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConnection {
    private static Connection connection = null;
    static {
        try {
            Class.forName(JdbcConstant.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD);
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

