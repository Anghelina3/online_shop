package usersAPP;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserData {
       private conToDataBase conToDataBase ;

       public List<USer> getUsers() {

	      List<USer> usersList = new ArrayList<>();

	      conToDataBase = new conToDataBase();
	      String query = "SELECT * FROM users";

	      try (Connection conn = conToDataBase.getConnection();
		   //обьект который отправляет в бд запрос
		   PreparedStatement stmt = conn.prepareStatement(query);
		   ResultSet rs = stmt.executeQuery()) {

		     while (rs.next()) {
			    String name = rs.getString("nameuser");
			    String login = rs.getString("loghin");
			    String pass = rs.getString("password1");
			    String imagePath = rs.getString("userimage");

			    int amount = rs.getInt("useramount"); // Предположим, что у вас есть столбец `userAmount`
			    System.out.println("Login: " + login);
			    System.out.println("Password: " + pass);

			    usersList.add(new USer(login, pass,name,  amount, imagePath));
		     }

	      } catch (SQLException e) {
		     e.printStackTrace();

	      }



        return usersList;
       }
}
