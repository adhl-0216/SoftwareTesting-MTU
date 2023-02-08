package TestLab1;

import Lab1.Driver;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DriverTest {
    @BeforeAll()
    static void beforeAll() {
        System.out.println("Before All");
    }
    @BeforeEach()
    void beforeEach(){
        System.out.println("Before Each");
    }

    @AfterEach()
    void afterEach(){
        System.out.println("After Each");
    }

    @AfterAll()
    static void afterAll(){
        System.out.println("After All");
    }


    @Test()
    @Order(2)
    void driverTest() {
        assertEquals(Driver.class, new Driver("Bob", 100).getClass());
    }

    @Test
    @Order(1)
    void invalidDriverNum(){
        assertThrows(IllegalArgumentException.class, () -> new Driver("Bob", 99));
    }

    @Test
    void invalidDriverName() {
        assertThrows(IllegalArgumentException.class, () -> new Driver("", 100));
    }

    @Test
    @Order(5)
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
        assertTimeout(Duration.ofMillis(150), () -> new Driver("Bob", 100).waitTillBanned());
    }
}
