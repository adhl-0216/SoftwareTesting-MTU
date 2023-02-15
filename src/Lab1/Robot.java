package Lab1;

import Lab3.RobotFees;

import static java.lang.Thread.sleep;

public class Robot {
    private String name;
    private boolean working = false;
    private int age;

    public Robot(String name) {
        setName(name);
    }
    public Robot(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String checkAge() {
        return (age > 20)?"Too old":"Age ok";
    }

    public double checkCost() {
        if (age <= 5) {
            return 10000.00;
        }
        else if (age <= 10) {
            return 7500.00;
        }
        else
            return 5000.00;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 30) throw new IllegalArgumentException();
        this.age = age;
    }

    public double getTotalCost(RobotFees robotFees){
        double cost;
        double fees;

        fees = robotFees.getCost(age);
        System.out.printf("for age %d the cost is %f.\n", age, checkCost());
        cost = checkCost() + fees;

        return cost;
    }
}
