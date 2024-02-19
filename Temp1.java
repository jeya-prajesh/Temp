import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CsvToOracle {
    public static void main(String[] args) {
        String csvFile = "your_csv_file.csv";
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "your_username";
        String password = "your_password";
        
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            
            String line;
            String sql = "INSERT INTO your_table_name (column1, column2, ...) VALUES (?, ?, ...)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // Skip header line if exists
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                // Set values for each column in the prepared statement
                statement.setString(1, data[0]);
                statement.setString(2, data[1]);
                // Add more setString statements for additional columns
                
                // Execute the statement
                statement.executeUpdate();
            }
            
            System.out.println("Data inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
