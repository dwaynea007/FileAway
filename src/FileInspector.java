import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        // Set up JFileChooser to open in the src directory
        JFileChooser fileChooser = new JFileChooser("src");

        int result = fileChooser.showOpenDialog(null);

        // If user selects a file, proceed with processing
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (Scanner scanner = new Scanner(selectedFile)) {
                System.out.println("File Contents:");

                // Read file line by line
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);

                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + selectedFile.getAbsolutePath());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
