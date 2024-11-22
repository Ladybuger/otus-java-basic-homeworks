package ru.otus.java.basic.homeworks.homework7;

public class Horse implements Transport {
    private String name;
    private int force;

    @Override
    public String getName() {
        return name;
    }

    public Horse(int force) {
        this.name = "OLGA";
        this.force = force;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.println("Лошадь " + name + " не может передвигаться по " + terrain);
            return false;
        }
        force  -= distance;
        System.out.println("Лошадь " + name + " прошла " + distance + "км по " + terrain + ". Энергии осталось " + force);
        return true;
    }

}