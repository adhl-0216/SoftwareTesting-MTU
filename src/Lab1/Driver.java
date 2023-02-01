package Lab1;
import static java.lang.Thread.sleep;

public class Driver {
    private int driverNum;
    private String driverName;
    private boolean banned = false;

    public Driver(String driverName, int driverNum) {
        setDriverNum(driverNum);
        setDriverName(driverName);
    }
    public int getDriverNum() {
        return driverNum;
    }
    private void setDriverNum(int driverNum) throws IllegalArgumentException {
        if (driverNum < 100) {
            throw new IllegalArgumentException();
        } this.driverNum = driverNum;
    }

    public String getDriverName() {
        return driverName;
    }
    private void setDriverName(String driverName) throws IllegalArgumentException {
        if (driverName.isEmpty()) {
            throw new IllegalArgumentException();
        } this.driverName = driverName;
    }

    public boolean check_status() {
        return banned;
    }

    public void waitTillBanned() throws InterruptedException {
         if (banned){
            sleep(100);
         }
    }
}
