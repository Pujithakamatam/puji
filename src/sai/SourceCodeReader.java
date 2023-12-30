package sai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SourceCodeReader {

    // Method to get the total number of lines in a file
    public static int getTotalLines(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int totalLines = 0;
            while (reader.readLine() != null) {
                totalLines++;
            }
            return totalLines;
        }
    }

    // Method to get the number of lines of code in the file (excluding comments and blank lines)
    public static int getCodeLines(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int codeLines = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                // Exclude blank lines and lines with only comments
                if (!line.trim().isEmpty() && !line.trim().startsWith("//") && !line.trim().startsWith("/*")) {
                    codeLines++;
                }
            }
            return codeLines;
        }
    }

    public static void main(String[] args) {
        try {
            String filePath = "src/sai/ab.java"; // Replace with the actual path to your source code file
            int totalLines = getTotalLines(filePath);
            int codeLines = getCodeLines(filePath);

            System.out.println("Total lines in the file: " + totalLines);
            System.out.println("Lines of code in the file: " + codeLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



	
