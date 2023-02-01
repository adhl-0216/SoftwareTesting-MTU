import Lab1.Robot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    Robot buddy = new Robot("buddy");

    @Test
    public void getNameTest() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void isNotWorking() {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void isWorking() {
        buddy.talkToRobot();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void getWorkingMessage(){
        buddy.talkToRobot();
        assertEquals("I'm in working mode", buddy.getWorkingMsg());
    }

    @Test()
    @DisplayName("getWorkingMessageFail catches the exception.")
    public void getWorkingMessageFail(){
        assertThrows(IllegalStateException.class, () -> buddy.getWorkingMsg());
    }

    @Test()
    public void testName_Fail(){
        assertThrows(IllegalStateException.class, () -> new Robot(""));
    }

    @Test
    public void waitTillWorking() throws InterruptedException {
            buddy.waitTillWorking();
    }

    @Test
    void timeoutExceeded() {
        //The following assertion fails with an error message similar to:
        //execution exceeded timout of 10 ms by 91 ms
        assertTimeout(Duration.ofMillis(150), () -> buddy.waitTillWorking());
    }
}