package Service;

import Connection.UserConnection;

import java.sql.*;
import java.util.Scanner;

public class UserServiceImpl implements UserService {

    @Override
    public void getPlanes() throws SQLException {
        String sql = "SELECT DISTINCT model, seats FROM plane_info";

        try (Connection connection = UserConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                String seats = resultSet.getString("seats");
                System.out.println("Plane model : " + model + ", total seats : " + seats);
            }
        }
    }

    @Override
    public void getPilots() throws SQLException {
        String sql = "SELECT DISTINCT name, age, plane_that_can_fly FROM pilot_info";

        try (Connection connection = UserConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                String planeThatCanFly = resultSet.getString("plane_that_can_fly");
                System.out.println("Pilot name : " + name + ", pilot age : " + age
                        + "plane that can fly : " + planeThatCanFly);
            }
        }
    }

    @Override
    public void getTotalPlanesSeats() throws SQLException {
        String sql = "SELECT SUM(seats) AS total_seats FROM plane_info";

        Connection connection = UserConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        int sum = 0;
        while (resultSet.next()) {
            sum = Integer.parseInt(resultSet.getString("total_seats"));
        }
        statement.close();
        connection.close();
        System.out.println("Total seats : " + sum);
    }


    @Override
    public void findPilotByID(Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM pilot_info WHERE pilot_ID = ?";
        System.out.println("Enter the pilotID");
        scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        Connection connection = UserConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String pilotId = resultSet.getString("pilot_ID");
            String name = resultSet.getString("name");
            String age = resultSet.getString("age");
            String birthday = resultSet.getString("birthday");
            String planeThatCanFly = resultSet.getString("plane_that_can_fly");
            System.out.println("info about pilot : " + pilotId + ", " + name + ", "
                    + age + ", " + birthday + ", " + planeThatCanFly + ", ");
        }
    }
}

