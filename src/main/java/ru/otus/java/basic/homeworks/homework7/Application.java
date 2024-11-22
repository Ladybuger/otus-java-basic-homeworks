package ru.otus.java.basic.homeworks.homework7;

public class Application {
    public static void main(String[] args) {
        Person person = new Person("Igor");

        Car car = new Car(30);
        person.move(23, Terrain.PLAIN);
        person.getIntoTransport(car);
        person.move(23, Terrain.PLAIN);
        person.move(45, Terrain.SWAMP);
        person.move(400, Terrain.PLAIN);
        person.getOutTransport();

        System.out.println();

        AllTerrainVehicle atv = new AllTerrainVehicle(50);
        person.getIntoTransport(atv);
        person.move(369, Terrain.PLAIN);
        person.getOutTransport();

        System.out.println();

        Horse horse = new Horse(4);
        person.getIntoTransport(horse);
        person.move(5, Terrain.PLAIN);
        person.move(5, Terrain.DENSE_FOREST);
        person.move(5, Terrain.SWAMP);
        person.getOutTransport();

        System.out.println();

        Bike bike = new Bike(5);
        person.getIntoTransport(bike);
        person.move(5, Terrain.PLAIN);
        person.getOutTransport();


    }
}
