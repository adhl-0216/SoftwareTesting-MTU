import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    private static Loan target;
    @BeforeAll()
    static void init() {
        target = new Loan();
    }
    @Test
    void getAmount() {
        target = new Loan(500, 1);
        double actual = target.getAmount();
        assertEquals(500, actual);
    }

    @Test
    @DisplayName("PT1")
    void PT1() {
        Loan subject = new Loan(500, 1);
        double actual = subject.getRate();
        double expected = 10;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("PT2")
    void PT2() {
        Loan subject = new Loan(5001, 1);
        double actual = subject.getRate();
        double expected = 8;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("PT3")
    void PT3() {
        Loan subject = new Loan(500, 4);
        double actual = subject.getRate();
        double expected = 6;
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("PT4")
    void PT4() {
        Loan subject = new Loan(5001, 4);
        double actual = subject.getRate();
        double expected = 5;
        assertEquals(expected, actual);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "positive_test_data.csv")
    void positiveTests(double amount, int period, double expectedRate) {
        Loan subject = new Loan(amount, period);
        double actual = subject.getRate();
        assertEquals(expectedRate, actual);
    }

    @ParameterizedTest()
    @CsvFileSource(resources = "negative_test_data.csv")
    void negativeTests_outOfRange(double amount, int period) {
        assertThrowsExactly(IllegalArgumentException.class,() ->new Loan(amount, period) );
    }
    @ParameterizedTest()
    @CsvSource({"str,1","500,str"})
    void negativeTests_invalidDataType(String amount, String period) {
        assertThrowsExactly(IllegalArgumentException.class,() ->new Loan(1, 1) );
    }

    @Test
    void getMonthlyPayment() {
        new Loan();
    }

    @Test
    void getTotalPayment() {
    }
}