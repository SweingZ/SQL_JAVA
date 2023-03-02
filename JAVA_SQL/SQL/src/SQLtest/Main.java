package SQLtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	

        String url = "jdbc:mysql://uyxixthxedavuoht:Yw9bQ6Vffz6sTz26MH8m@bwejh8xhpfhg1hi5khhq-mysql.services.clever-cloud.com:3306/bwejh8xhpfhg1hi5khhq";
        String username = "uyxixthxedavuoht";
        String password = "Yw9bQ6Vffz6sTz26MH8m";

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database.");
        
        // Perform database operations here...
        
        // Example: Execute a SELECT query and retrieve data
        String sql = "SELECT * FROM customers";
        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, 18);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            String name = rs.getString("first_name");
            int age = rs.getInt("phone");
            System.out.println("Name: " + name + ", Phone: " + age);
        }
        
        rs.close();
        stmt.close();
        
        conn.close();
        System.out.println("Disconnected from database.");
    }
}
