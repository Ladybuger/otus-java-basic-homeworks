package ru.otus.java.basic.homeworks.homework6;

public class MainApplication {
    public static void main(String[] args) {
        Plate plate = new Plate(30, 115);
        plate.info();

        plate.addFood(3);
        plate.info();
        plate.removeFood(100);
        plate.info();

        Cat[] cats = {
                new Cat("Vasya", 23),
                new Cat("Artem", 56),
                new Cat("Vadim", 34),
                new Cat("Evgeniy", 45),
                new Cat("Georgiy", 12),
                new Cat("Ildar", 123),
                new Cat("Egor", 23)
        };

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}
