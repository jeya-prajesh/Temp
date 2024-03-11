import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAllValues {
    public static void main(String[] args) {
        // JDBC URL, username, and password of Oracle database
        String url = "jdbc:oracle:thin:@//localhost:1521/yourDatabaseName";
        String user = "yourUsername";
        String password = "yourPassword";
        
        // SQL query to delete all values in a table
        String sql = "DELETE FROM yourTableName";
        
        try (
            // Get a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Create a statement
            Statement stmt = conn.createStatement();
        ) {
            // Execute the SQL query
            stmt.executeUpdate(sql);
            
            System.out.println("All values deleted successfully from the table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
