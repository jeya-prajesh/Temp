public static String[][] readCSV(String csvFile) throws IOException, CsvException {
    List<String[]> lines;
    String[][] array2D = null;
    try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
        // Read all lines from the CSV file
        lines = reader.readAll();

        // Initialize a 2D string array
        array2D = new String[lines.size()][lines.get(0).length - 1]; // Assuming all rows have the same number of columns

        // Iterate over the lines and fill the array, skipping the first column if it's empty
        int rowIndex = 0;
        for (String[] line : lines) {
            // Check if the first column (header) is empty
            if (!line[0].isEmpty()) {
                for (int j = 1; j < line.length; j++) {
                    array2D[rowIndex][j - 1] = line[j];
                }
                rowIndex++;
            }
        }
    }
    // Resize array2D to remove any empty rows
    array2D = Arrays.copyOf(array2D, rowIndex);
    return array2D;
}
