package TestLab3;

import Lab3.Repository;
import Lab3.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

   // The class we want to mock
    @Mock
    Repository repository;

    // The class that will use the mock
    @InjectMocks
    Service service;

    @Test
    void testSuccess() {
        // Setup mock scenario
        try {
            Mockito.when(repository.getStuff()).thenReturn(Arrays.asList("A", "B", "CDEFGHIJK", "12345", "1234"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Execute the service that uses the mocked repository
        List<String> stuff = service.getStuffWithLengthLessThanFive();

        // Validate the response
        Assertions.assertNotNull(stuff);
        Assertions.assertEquals(3, stuff.size());
        System.out.println(stuff);
    }

    @Test
    void testException() {
        // Setup mock scenario
        try {
            Mockito.when(repository.getStuff()).thenThrow(new SQLException("Connection Exception"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Execute the service that uses the mocked repository
        List<String> stuff = service.getStuffWithLengthLessThanFive();

        // Validate the response
        Assertions.assertNotNull(stuff);
        Assertions.assertEquals(0, stuff.size());
        Assertions.assertThrows(SQLException.class, () -> repository.getStuff());
        System.out.println(stuff);
    }
}