package pt.bercait.challenges.aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day01Part1 {
    private static final String INPUT_PATH = "/../inputs/day_01.txt";
    private final String inputPath;

    public Day01Part1() {
        String filePath = new File("").getAbsolutePath();
        this.inputPath = filePath.concat(INPUT_PATH);
    }

    public int extractNumbers(String text) {
        int left = 0, right = 0;

        for (int i = 0; i <= text.length() - 1; i++) {
            if (left == 0) {
                char start = text.charAt(i);
                if (Character.isDigit(start)) {
                    left = Character.getNumericValue(start) * 10;
                }
            }

            if (right == 0) {
                char last = text.charAt(text.length() - 1 - i);
                if (Character.isDigit(last)) {
                    right = Character.getNumericValue(last);
                }
            }

            if (left > 0 && right > 0) {
                break;
            }
        }

        return left + right;
    }

    public int calculateTotal(BufferedReader reader) throws IOException {
        int total = 0;
        String line = reader.readLine();

        while (line != null) {
            total += this.extractNumbers(line);
            line = reader.readLine();
        }

        return total;
    }

    public int run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.inputPath))) {
            int result = this.calculateTotal(reader);
            System.out.println(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int calculateTotalWithStream(Stream<String> stream) throws IOException {
        return stream.parallel()
                .map(this::extractNumbers)
                .reduce(0, Integer::sum);
    }

    public int runWithStream() {
        try (Stream<String> lines = Files.lines(Paths.get(this.inputPath))) {
            int result = this.calculateTotalWithStream(lines);
            System.out.println(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
