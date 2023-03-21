import Service.UserService;
import Service.UserServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("___________________________________________");
            System.out.println("Hello, enter the numeric for info");
            System.out.println("1 Airplanes that we use");
            System.out.println("2 List of pilots");
            System.out.println("3 Find the pilot by ID");
            System.out.println("4 Information about total number of seats");
            System.out.println("0 Exit");
            System.out.println("__________________________________________");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    userService.getPlanes();
                    break;
                case 2:
                    userService.getPilots();
                    break;
                case 3:
                    userService.findPilotByID(scanner);
                    break;
                case 4:
                    userService.getTotalPlanesSeats();
                    break;
                case 0:
                    System.out.println("Bye-bye");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("wrong numeric");
            }
        }
    }
}