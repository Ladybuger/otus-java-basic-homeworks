package ru.otus.java.basic.homeworks.homework6;

public class Plate {
    private int maxFood;
    private int currentFood;

    public int getMaxFood() {
        return maxFood;
    }

    public void setMaxFood(int maxFood) {
        this.maxFood = maxFood;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void setCurrentFood(int currentFood) {
        this.currentFood = currentFood;
    }

    public Plate(int maxFood, int currentFood) {
        this.maxFood = maxFood;
        this.currentFood = currentFood;
    }

    public void addFood(int food) {
        if (currentFood + food <= maxFood) {
            currentFood += food;
        } else {
            currentFood = maxFood;
        }
    }

    public boolean removeFood(int food) {
        if (currentFood - food >= 0) {
            currentFood -= food;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("Максимальное количество еды: " + maxFood + "\n" + "Текущее количество еды: " + currentFood);
        System.out.println();
    }

}
