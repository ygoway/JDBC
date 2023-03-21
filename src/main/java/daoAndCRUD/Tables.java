package daoAndCRUD;

import java.sql.*;

import Connection.JdbcConstant;

public class Tables {

    public void createTableOfAirplanes() {
        String sql = "CREATE TABLE plane_info (plane_ID INT NOT NULL PRIMARY KEY, \n" +
                "   model VARCHAR(25) NOT NULL,\n" +
                "   serial_number VARCHAR(15) NOT NULL,\n" +
                "   seats INT NOT NULL);";

        try (Connection connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
            System.out.println("Creating table " + sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTableOfPilots() {
        String sql = "CREATE TABLE pilot_info (pilot_ID INT NOT NULL PRIMARY KEY, \n" +
                "   name VARCHAR(25) NOT NULL,\n" +
                "   age INT NOT NULL,\n" +
                "   birthday DATE NOT NULL,\n" +
                "   plane_that_can_fly VARCHAR(200) NOT NULL);";

        try (Connection connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
            System.out.println("Creating table " + sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertPlaneData() {
        String sql = "INSERT INTO plane_info (plane_ID, model, serial_number, seats)" +
                " VALUES (1, 'An-148', 'pp758899_dd', 85),\n" +
                "       (2, 'An-158', 'kk765439_dd', 100),\n" +
                "       (3, 'An-158', 'kk787542_dd', 100),\n" +
                "       (4, 'An-148', 'pp897865_dd', 85),\n" +
                "       (5, 'An-148', 'pp987789_dd', 85),\n" +
                "       (6, 'An-148', 'pp127647_dd', 85),\n" +
                "       (7, 'An-148', 'pp948577_dd', 85);";

        try (Connection connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
            System.out.println("Was added to table : " + sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertPilotData() {
        String sql = "INSERT INTO pilot_info (pilot_ID, name, age, birthday, plane_that_can_fly)" +
                " VALUES (1, 'Mykola', 26, '1997-01-22', 'An-158'),\n" +
                "       (2, 'Artem', 27, '1996-02-09', 'An-148, An-158'),\n" +
                "       (3, 'Borys', 30, '1993-05-21', 'An-148, An-158'),\n" +
                "       (4, 'Olga', 25, '1998-05-22', 'An-148'),\n" +
                "       (5, 'Stepan', 31, '1992-09-11', 'An-148'),\n" +
                "       (6, 'Maryna', 31, '1992-07-05', 'An-148'),\n" +
                "       (7, 'Petro', 29, '1994-05-27', 'An-148');";

        try (Connection connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
            System.out.println("Was added to table : " + sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePilotData() {
        String sql = "UPDATE pilot_info" +
                "SET plane_that_can_fly = 'An-148, An-158'\n" +
                "WHERE pilot_ID = 4";

        try (Connection connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
            System.out.println("Changes : " + sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRow() {
        String sql = "DELETE FROM pilot_info WHERE age >= 40";

        try (Connection connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
            System.out.println("Deleted from table : " + sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropTable() {
        String sql = "DROP TABLE plane_info";

        try (Connection connection = DriverManager.getConnection(JdbcConstant.JDBC_URL, JdbcConstant.USERNAME, JdbcConstant.PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
            System.out.println("Deleted from table : " + sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

