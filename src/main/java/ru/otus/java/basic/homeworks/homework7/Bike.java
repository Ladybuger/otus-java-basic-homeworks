package ru.otus.java.basic.homeworks.homework7;

public class Bike implements Transport {
    private String name;
    private int energy;

    @Override
    public String getName() {
        return name;
    }

    public Bike(int energy) {
        this.name = "Forward";
        this.energy = energy;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Велосипед " + name + "не может передвигаться по " + terrain);
            return false;
        }
        energy  -= distance;
        System.out.println("Велосипед " + name + " проехал " + distance + " км по " + terrain + ". Энергии осталось " + energy);
        return true;
    }

}
