import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderExample {
    public static void main(String[] args) {
        // Path to your CSV file
        String csvFile = "your_file.csv";

        try {
            // Create a CSVReader object
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            
            // Read all lines from the CSV file
            List<String[]> lines = reader.readAll();
            
            // Initialize a 2D string array
            String[][] array2D = new String[lines.size()][lines.get(0).length - 1]; // Assuming all rows have the same number of columns

            // Iterate over the lines and fill the array, skipping the first column
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i);
                for (int j = 1; j < line.length; j++) {
                    array2D[i][j - 1] = line[j];
                }
            }

            // Close the reader
            reader.close();
            
            // Now, array2D contains the desired data with the first column skipped
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
