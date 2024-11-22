package ru.otus.java.basic.homeworks.homework7;

public class AllTerrainVehicle implements Transport {
    private String name;
    private int fuel;
    public static final double FUEL_CONSUMPION = 0.09; // расход топлива: ~9л на 100 км

    @Override
    public String getName() {
        return name;
    }

    public AllTerrainVehicle(int fuel) {
        this.name = "NIVA";
        this.fuel = fuel;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (fuel < distance * FUEL_CONSUMPION) {
            System.out.println("Вездеходу " + name + " недостаточно бензина в " + fuel + " литр, чтобы проехать " + distance + " км");
            return false;
        }
        fuel -= distance * FUEL_CONSUMPION;
        System.out.println("Вездеход " + name + " проехал " + distance + " км по " + terrain + ". Потратил " + Math.round(distance * FUEL_CONSUMPION) + "л бензина. Осталось " + fuel + "л.");
        return true;
    }
}
