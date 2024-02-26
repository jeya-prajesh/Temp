import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReaderExample {
    public static void main(String[] args) {
        // Path to your CSV file
        String csvFile = "your_file.csv";

        // Call the function to read CSV and store data in a 2D array
        String[][] data = null;
        try {
            data = readCSV(csvFile);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        // Print the data for verification
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static String[][] readCSV(String csvFile) throws IOException, CsvException {
        List<String[]> lines = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Read all lines from the CSV file
            lines = reader.readAll();

            // Initialize a 2D string array
            String[][] array2D = new String[lines.get(0).length - 1][lines.size()]; // Assuming all rows have the same number of columns

            // Iterate over the lines and fill the array, skipping the first column if it's empty
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i);
                for (int j = 1; j < line.length; j++) {
                    array2D[j - 1][i] = line[j];
                }
            }
            return array2D;
        }
    }
}
