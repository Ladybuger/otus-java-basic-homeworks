package ru.otus.java.basic.homeworks.homework7;

public class Car implements Transport {
    private String name;
    private int fuel;
    public static final double FUEL_CONSUMPION = 0.07; // расход топлива: ~7л на 100 км

    @Override
    public String getName() {
        return name;
    }

    public Car(int fuel) {
        this.name = "LADA GRANTA";
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (this.fuel < distance * FUEL_CONSUMPION) {
            System.out.println("Автомобилю " + this.name + " недостаточно бензина в " + this.fuel + " литр, чтобы проехать " + distance + " км");
            return false;
        }

        if (terrain == Terrain.DENSE_FOREST || terrain == Terrain.SWAMP) {
            System.out.println("Автомобиль " + this.name + " не может проехать по " + terrain);
            return false;
        }
        this.fuel -= distance * FUEL_CONSUMPION;
        System.out.println("Автомобиль " + this.name + " проехал " + distance + " км по " + terrain + ". Потратил " + Math.round(distance * FUEL_CONSUMPION) + "л бензина. Осталось " + this.fuel + "л.");
        return true;
    }

}
