package Service;

import java.sql.SQLException;
import java.util.Scanner;

public interface UserService {
    void getPlanes () throws SQLException;
    void getPilots () throws SQLException;
    void getTotalPlanesSeats () throws SQLException;
    void findPilotByID (Scanner scanner) throws SQLException;
}
