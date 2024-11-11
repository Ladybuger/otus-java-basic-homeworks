package ru.otus.java.basic.homeworks.homework5;
import ru.otus.java.basic.homeworks.homework5.animals.Cat;
import ru.otus.java.basic.homeworks.homework5.animals.Dog;
import ru.otus.java.basic.homeworks.homework5.animals.Horse;

public class MainApplication {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 50,2, 5);
        cat.run(50);
        cat.swim(50);
        cat.info();
        System.out.println("-------------------");

        Dog dog = new Dog("Bobik", 50,2, 5);
        dog.run(50);
        dog.swim(50);
        dog.info();
        System.out.println("-------------------");

        Horse horse = new Horse("Loshad", 100, 4, 2);
        horse.run(100);
        horse.swim(100);
        horse.info();
        System.out.println("-------------------");

    }

}
