package pt.bercait.challendes.aoc;

import org.junit.jupiter.api.Test;
import pt.bercait.challenges.aoc.Day01Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Part1Tests {
    Day01Part1 day01Part1 = new Day01Part1();

    @Test
    public void verifyExtractNumbers() {
        assertEquals(12, day01Part1.extractNumbers("1abc2"));
        assertEquals(38, day01Part1.extractNumbers("pqr3stu8vwx"));
        assertEquals(15, day01Part1.extractNumbers("a1b2c3d4e5f"));
        assertEquals(77, day01Part1.extractNumbers("treb7uchet"));
    }

    @Test
    public void verifyCalculateTotal() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new StringReader("""
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet"""));

        assertEquals(142, day01Part1.calculateTotal(bufferedReader));
    }

    @Test
    public void verifyRun() {
        assertEquals(53386, day01Part1.run());
    }

    @Test
    public void verifyCalculateTotalWithStream() throws IOException {
        Stream<String> inputStream = Stream.of(
                "1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet");

        assertEquals(142, day01Part1.calculateTotalWithStream(inputStream));
    }

    @Test
    public void verifyRunWithStream() {
        assertEquals(53386, day01Part1.runWithStream());
    }

}
