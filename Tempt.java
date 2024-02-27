import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
            // Skip the first row (header)
            reader.readNext();

            // Read all lines from the CSV file starting from the second row
            String[] line;
            while ((line = reader.readNext()) != null) {
                lines.add(line);
            }

            // Initialize a 2D string array
            String[][] array2D = new String[lines.get(0).length][lines.size()]; // Assuming all rows have the same number of columns

            // Iterate over the lines and fill the array
            for (int i = 0; i < lines.size(); i++) {
                String[] row = lines.get(i);
                for (int j = 0; j < row.length; j++) {
                    array2D[j][i] = row[j];
                }
            }
            return array2D;
        }
    }
}
