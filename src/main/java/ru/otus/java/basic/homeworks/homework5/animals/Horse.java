package ru.otus.java.basic.homeworks.homework5.animals;

public class Horse extends Animal{

    public Horse(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
    }

    @Override
    public double swim(int distance) {
        double time;
        if (endurance >= distance * 4) {
            endurance -= distance;
            time = swimmingSpeed / distance;
        } else {
            System.out.println("У " + name + " появилось чувство усталости.");
            time = -1;
        }
        return time;
    }
}
