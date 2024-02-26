import java.io.BufferedReader;
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
        } catch (IOException e) {
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

    public static String[][] readCSV(String csvFile) throws IOException {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma
                String[] columns = line.split(",");
                // Replace "PS" with "P" in the 2nd column
                columns[1] = columns[1].equals("PS") ? "P" : columns[1];
                // Add the columns to the list
                lines.add(columns);
            }
        }

        // Convert the list to a 2D array
        String[][] array2D = new String[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            array2D[i] = lines.get(i);
        }
        return array2D;
    }
}
