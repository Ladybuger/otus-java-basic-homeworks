package ru.otus.java.basic.homeworks.homework7;
import static ru.otus.java.basic.homeworks.homework7.Terrain.*;

public class Person {
    private String name;
    private Transport currentTransport;

    public Person(String name) {
        this.name = name;
    }

    public void getIntoTransport(Transport currentTransport) {
        this.currentTransport = currentTransport;
        System.out.println(name + " сел в/на " + this.currentTransport.getName());
    }

    public void getOutTransport() {
        if (this.currentTransport != null) {
            System.out.println(name + " вышел/слез из/с " + this.currentTransport.getName());
            this.currentTransport = null;
            return;
        }
        System.out.println("У " + this.name + " нет транспорта для передвижения((((((");
    }

    public boolean move(int distance, Terrain terrain) {
        if (this.currentTransport != null) {
            return currentTransport.move(distance, terrain);
        }
        System.out.println("У " + this.name + " нет транспорта для передвижения((((((. Прошел пешком " + distance + "км по " + terrain);
        return false;
    }


}
