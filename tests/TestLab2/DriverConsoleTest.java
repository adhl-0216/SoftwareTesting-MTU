package TestLab2;

import Lab1.Driver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DriverConsoleTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @ParameterizedTest()
    @CsvSource({"1000","5000"})
    void testNumberValid(int driverNum) throws IOException {
        System.setOut(new PrintStream(outContent));
        Driver bob = new Driver("Bob", driverNum);
        bob.checkNumberValid();
        outContent.flush();
        String[] linesOfOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("Driver number valid",linesOfOutput[0]);
    }

    @ParameterizedTest()
    @CsvSource({"5001","9999"})
    void testNumberInvalid(int driverNum) throws IOException {
        System.setOut(new PrintStream(outContent));
        Driver bob = new Driver("Bob", driverNum);
        bob.checkNumberValid();
        outContent.flush();
        String[] linesOfOutput = outContent.toString().split(System.lineSeparator());
        assertEquals("Error Driver number not valid",linesOfOutput[0]);
    }
}
