package ru.otus.java.basic.homeworks.homework6;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public boolean eat(Plate plate) {
        isFull = plate.removeFood(appetite);

        return isFull;
    }

    public void info() {
        if (isFull) {
            System.out.println("Котик " + name + " сыт.");
        } else {
            System.out.println("Котик " + name + " голоден.");
        }

    }


}
