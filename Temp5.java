import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    public static void main(String[] args) {
        String csvFile = "your_file.csv";
        String[][] table = readCSV(csvFile);
        // Now, table contains the desired 2D string array
    }

    public static String[][] readCSV(String csvFile) {
        String line;
        String csvSplitBy = ",";
        int rowCount = 0;
        int colCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the first line
            br.readLine();

            // Count the number of rows and columns
            while ((line = br.readLine()) != null) {
                rowCount++;
                String[] row = line.split(csvSplitBy);
                colCount = row.length - 1; // Skip the first column
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[][] table = new String[rowCount][colCount];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the first line
            br.readLine();

            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] rowValues = line.split(csvSplitBy);
                // Skip the first column and transpose rows into columns
                for (int i = 1; i < rowValues.length; i++) {
                    table[row][i - 1] = rowValues[i];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return table;
    }
}
