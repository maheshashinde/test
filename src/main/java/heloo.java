import java.io.*;
import java.sql.*;

public class heloo {
   
  public static void main(String[] args) {

    try {
      // Connect to the database
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
      
      // Get user input
      String username = args[0];
      
      // Construct SQL query
      String sql = "SELECT * FROM users WHERE username = '" + username + "'";
      
      // Execute query
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      
      // Process results
      while (rs.next()) {
        String resultUsername = rs.getString("username");
        String resultPassword = rs.getString("password");
        System.out.println("Username: " + resultUsername + ", Password: " + resultPassword);
      }
      
      // Clean up
      rs.close();
      stmt.close();
      conn.close();
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
