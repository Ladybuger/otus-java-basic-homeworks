package ru.otus.java.basic.homeworks.homework5.animals;

public class Dog extends Animal {

    public Dog(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
    }

    @Override
    public double swim(int distance) {
        double time;
        if (endurance >= distance * 2) {
            endurance -= distance;
            time = swimmingSpeed / distance;
        } else {
            System.out.println("У " + name + " появилось чувство усталости.");
            time = -1;
        }
        return time;
    }

}
