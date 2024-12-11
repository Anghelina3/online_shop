package usersAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conToDataBase {
       private Connection connection;
       conToDataBase(){
	      String url = "jdbc:postgresql://localhost:5432/users";
	      String user = "postgres";
	      String password = "1234";
       try {
	      connection = DriverManager.getConnection(url, user, password);
       } catch (SQLException e) {
	      throw new RuntimeException(e);
       }

       }

       public Connection getConnection(){
	      return connection;
       }
}
