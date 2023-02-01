import Lab1.Driver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    @Test()
    void driverTest() {
        Driver bob = new Driver("Bob", 100);
        assertEquals(Driver.class, bob.getClass());
    }

    @Test
    void invalidDriverNum(){
        assertThrows(IllegalArgumentException.class, () -> new Driver("Bob", 99));
    }

    @Test
    void invalidDriverName() {
        assertThrows(IllegalArgumentException.class, () -> new Driver("", 100));
    }

    @Test
    void getDriverNameTest() {
        assertEquals("Bob", new Driver("Bob", 100).getDriverName());
    }

    @Test
    void getDriverNumTest() {
        assertEquals(100, new Driver("Bob", 100).getDriverNum());
    }

    @Test
    void checkStatusTest() {
        assertFalse(new Driver("Bob", 100).check_status());
    }

    @Test()
    @DisplayName("To check if Driver is timed out for 100ms.")
    void timeout() {
        Driver bob = new Driver("Bob", 100);
        assertTimeout(Duration.ofMillis(150), bob::waitTillBanned);
    }
}
