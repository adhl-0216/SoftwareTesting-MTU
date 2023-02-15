package TestLab3;

import Lab1.Robot;
import Lab3.RobotFees;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RobotMockTest {
    @Mock
    RobotFees mockRobotFees;

    @InjectMocks
    Robot robert = new Robot("robert", 5);

    @Test()
    @DisplayName("Test getTotalCost()")
    void testGetTotalCost() {
        Mockito.when(mockRobotFees.getCost(5)).thenReturn(500.00);
        double actual = robert.getTotalCost(mockRobotFees);

        assertEquals(10500.00, actual, 0.005);
        System.out.println("total cost is " + actual);

        Mockito.verify(mockRobotFees).getCost(5);
    }
}