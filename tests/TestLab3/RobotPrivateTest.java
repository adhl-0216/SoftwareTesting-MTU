package TestLab3;

import Lab1.Robot;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotPrivateTest {

    @Test
    void testAgeMember() throws Exception {
        System.out.println("testAgeMember");
        Robot target = new Robot("buddy",5);

        Class<? extends Robot> secretClass = target.getClass();
        Field f = secretClass.getDeclaredField("age");
        f.setAccessible(true);

        System.out.println("The value in f(age) is " + f.get(target));

        int result = f.getInt(target);

        assertEquals(5, result);
    }

    @Test
    void testSetAgeMethod() throws Exception {
        System.out.println("test setAge()");
        Robot target = new Robot("buddy", 3);

        Method method = Robot.class.getDeclaredMethod("setAge", int.class);
        method.setAccessible(true);

        method.invoke(target, 7);
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("age");
        f.setAccessible(true);

        int result = f.getInt(target);
        System.out.println("The value in f(age) is " + f.get(target));
        assertEquals(7, result);
    }
}