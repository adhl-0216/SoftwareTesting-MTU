package TestLab3;

import Lab1.Driver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.*;

class DriverPrivateTest {
    @Test
    void testSetDriverNum() throws Exception{
        System.out.println("testing setDriverNUm()");
        Driver target = new Driver("Bob", 500);

//        Class<? extends Driver> secretClass = target.getClass();
        Class<Driver> secretClass = Driver.class;
        Method setDriverNum = secretClass.getDeclaredMethod("setDriverNum", int.class);
        setDriverNum.setAccessible(true);
        Field driverNum = secretClass.getDeclaredField("driverNum");
        driverNum.setAccessible(true);

        setDriverNum.invoke(target, 420);

        int actual = driverNum.getInt(target);
//        int actual = (int)driverNum.get(target);
        System.out.println("The driverNum is set to " + driverNum.get(target));
        assertEquals(420, actual);
    }
}