package Lab1;

import static java.lang.Thread.sleep;

public class Robot {
    private String name;
    private boolean working = false;

    public Robot(String name) {
        setName(name);
    }

    public boolean isWorking() {
        return working;
    }

    public void talkToRobot(){
        working = true;
    }

    public String getWorkingMsg() {
        if(!working) {
            throw new IllegalStateException();
        }
        return "I'm in working mode";
    }

    public void waitTillWorking() throws InterruptedException {
//        while (!working) {
            sleep(100);
//        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalStateException();
        }
        this.name = name;
    }
}
