import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testcaseChecker {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("testcase.txt"))) {
            String line;
            int sampleNumber = 0;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Sample")) {
                    sampleNumber++;
                    List<String> inputLines = readLines(br);
                    List<String> expectedOutputLines = readLines(br);
                    
                    // Call your function here

                    boolean isCorrect = compareOutput(expectedOutputLines, actualOutputLines);
                    System.out.println("Sample " + sampleNumber + " = " + isCorrect);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.startsWith("Sample")) {
            lines.add(line.trim());
        }
        return lines;
    }

    private static boolean compareOutput(List<String> expected, List<String> actual) {
        if (expected.size() != actual.size()) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                return false;
            }
        }
        return true;
    }
}

