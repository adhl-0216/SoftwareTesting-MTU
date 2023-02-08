package TestLab2;

import Lab1.Robot;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RobotParamTest {

    @ParameterizedTest()
    @CsvSource({"10,Age ok", "20,Age ok", "25,Too old"})
    void testCheckAge_CsvSource(int age, String expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkAge());
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "ParamTestFile.csv", numLinesToSkip = 1)
    void testCheckAge_CsvFileSource(int age, String expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkAge());
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "checkCostResource.csv")
    void testCheckCost_CsvSource(int age, double expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost());
    }
}
