import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderExample {
    public static void main(String[] args) {
        // Path to your CSV file
        String csvFile = "your_file.csv";

        // Call the function to read CSV and store data in a 2D array
        String[][] data = readCSV(csvFile);

        // Print the data for verification
        for (String[] row : data) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static String[][] readCSV(String csvFile) {
        List<String[]> lines = new ArrayList<>();
        String[][] array2D = null;
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Read all lines from the CSV file
            lines = reader.readAll();

            // Initialize a 2D string array
            array2D = new String[lines.size()][lines.get(0).length - 1]; // Assuming all rows have the same number of columns

            // Iterate over the lines and fill the array, skipping the first column
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i);
                for (int j = 1; j < line.length; j++) {
                    array2D[i][j - 1] = line[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array2D;
    }
}
