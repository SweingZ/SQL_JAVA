import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseExample {
    public static void main(String[] args) {
        String hostname = "bmamm5nlbfzedak3lhcl-mysql.services.clever-cloud.com";
        String database_name = "bmamm5nlbfzedak3lhcl";
        String user = "u9bhz1ixuagi37pp";
        String password = "noDss9xJ15yIYLyFprlD";
        int port = 3306;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + hostname + ":" + port + "/" + database_name, user, password);

            // Create a table
                // String create_table_query = "CREATE TABLE IF NOT EXISTS users ("
                //         + "id INT PRIMARY KEY AUTO_INCREMENT,"
                //         + "name VARCHAR(255),"
                //         + "email VARCHAR(255)"
                //         + ")";
                // stmt = conn.prepareStatement(create_table_query);
                // stmt.executeUpdate();

            // Insert a record
                // String insert_query = "INSERT INTO users (name, email) VALUES (?, ?)";
                // stmt = conn.prepareStatement(insert_query);
                // stmt.setString(1, "John Doe");
                // stmt.setString(2, "john.doe@example.com");
                // stmt.executeUpdate();

            // Read records
            String select_query = "SELECT * FROM users";
            stmt = conn.prepareStatement(select_query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("email"));
            }

            // Update a record
                // String update_query = "UPDATE users SET email=? WHERE id=?";
                // stmt = conn.prepareStatement(update_query);
                // stmt.setString(1, "jane.doe@example.com");
                // stmt.setInt(2, 1);
                // stmt.executeUpdate();

            // Delete a record
                // String delete_query = "DELETE FROM users WHERE id=?";
                // stmt = conn.prepareStatement(delete_query);
                // stmt.setInt(1, 1);
                // stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection and statement
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
