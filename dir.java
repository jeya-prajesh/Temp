import java.io.File;
import java.io.IOException;

public class Loader {
    public static void main(String[] args) {
        // Define the command and working directory
        String[] command = {"sqlldr", "un/pw", "control=of.ctl"};
        File directory = new File("uploads");

        // Execute the command
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.directory(directory);
            Process process = pb.start();
            
            // Wait for the process to finish
            int exitCode = process.waitFor();
            
            // Check if the process terminated successfully
            if (exitCode == 0) {
                System.out.println("Command executed successfully.");
            } else {
                System.err.println("Error executing command. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
