package ru.otus.java.basic.homeworks.homework5.animals;

public abstract class Animal {
    String name;
    int runningSpeed;
    int swimmingSpeed;
    int endurance;

    public Animal(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.endurance = endurance;
    }

    public double run(int distance) {
        double time;
        if (endurance >= distance * 1) {
            endurance -= distance;
            time = runningSpeed / distance;
        } else {
            System.out.println("У " + name + " появилось чувство усталости.");
            time = -1;
        }
        return time;
    }

    public double swim(int distance) {
        System.out.println(name + " не умеет плавать.");
        return -1;
    }

    public void info() {
        System.out.println("Животное зовут: " + name);
        System.out.println("У " + name + " выносливость равна: " + endurance + " ед");
        System.out.println("У " + name + " скорость бега равна: " + runningSpeed + " м/с");
        System.out.println("У " + name + " скорость плавания равна: " + runningSpeed + " м/с");

    }
}
