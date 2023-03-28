import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {
    @Test
    void getAmount() {
        Loan subject = new Loan(500, 1);
        double actual = subject.getAmount();
        assertEquals(500, actual);
    }

    @Test
    void getPeriod() {
        Loan subject = new Loan(500, 1);
        double actual = subject.getPeriod();
        assertEquals(1, actual);
    }

    @Test
    void setAmount() throws Exception {
        Method setAmount = Loan.class.getDeclaredMethod("setAmount", double.class);
        setAmount.setAccessible(true);

        Loan subject = new Loan();
        setAmount.invoke(subject, 500);
        assertEquals(500, subject.getAmount());
    }

    @Test
    void setPeriod() throws Exception {
        Method setPeriod = Loan.class.getDeclaredMethod("setPeriod", int.class);
        setPeriod.setAccessible(true);

        Loan subject = new Loan();
        setPeriod.invoke(subject, 2);
        assertEquals(2, subject.getPeriod());
    }

    @Test
    void setRate() throws Exception {
        Method setRate = Loan.class.getDeclaredMethod("setRate", int.class);
        setRate.setAccessible(true);

        Loan subject = new Loan(1000, 4);
        setRate.invoke(subject, 2);
        assertEquals(10, subject.getRate());
    }

    @ParameterizedTest(name = "PT{index}: Amount = {0}, Period = {1}")
    @CsvFileSource(resources = "positive_test_data.csv", numLinesToSkip = 1)
    void positiveTests(double amount, int period, double expectedRate, double expectedMonthlyPayment, double expectedTotalPayment) {
        Loan subject = new Loan(amount, period);
        double actual = subject.getRate();
        assertEquals(expectedRate, actual);
        double monthlyPayment = Math.round(subject.getMonthlyPayment()*100)/100.0;
        assertEquals(expectedMonthlyPayment, monthlyPayment);
        double totalPayment = Math.round(subject.getTotalPayment()*100)/100.0;
        assertEquals(expectedTotalPayment, totalPayment);
    }

    @ParameterizedTest(name = "NT{index}: Amount = {0}, Period = {1}")
    @CsvFileSource(resources = "negative_test_data.csv", numLinesToSkip = 1)
    void negativeTests(double amount, int period) {
        assertThrowsExactly(
                IllegalArgumentException.class,
                () -> new Loan(amount, period)
        );
    }
}