import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileContentReader {
    public static void main(String[] args) {
        String filePath = "your_file_path_here.txt";
        int skipCharacters = 10; // Number of characters to skip
        int readCharacters = 20; // Number of characters to read

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            // Skip characters
            bufferedReader.skip(skipCharacters);

            // Read characters into a string
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            int character;
            while ((character = bufferedReader.read()) != -1 && count < readCharacters) {
                stringBuilder.append((char) character);
                count++;
            }
            String content = stringBuilder.toString();
            System.out.println("Content: " + content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
