import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.exceptions.CsvException;
import java.util.Arrays;

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
            for (String[] row : data) {
                for (String cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
        }
    }

    public static String[][] readCSV(String csvFile) throws IOException, CsvException {
        List<String[]> lines;
        String[][] array2D = null;
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Read all lines from the CSV file
            lines = reader.readAll();

            // Filter out rows with empty headers
            List<String[]> filteredLines = new ArrayList<>();
            for (String[] line : lines) {
                if (!line[0].isEmpty()) {
                    filteredLines.add(Arrays.copyOfRange(line, 1, line.length));
                }
            }

            // Convert the list to a 2D array
            array2D = new String[filteredLines.size()][];
            for (int i = 0; i < filteredLines.size(); i++) {
                array2D[i] = filteredLines.get(i);
            }
        }
        return array2D;
    }
}
