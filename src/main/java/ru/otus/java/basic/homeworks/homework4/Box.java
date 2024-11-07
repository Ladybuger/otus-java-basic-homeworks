package ru.otus.java.basic.homeworks.homework4;

public class Box {
    int length, width, height;
    String color, thing;
    boolean isOpen = true;
    boolean isEmpty = true;


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Box (int length, int width, int height, String color, String thing) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.thing = thing;
    }

    public void open() {
        System.out.println("Коробку открыли");
    }

    public void close() {
        System.out.println("Коробку закрыли");
    }

    public void put(String thing) {
        if (isOpen) {
            if (isEmpty) {
                System.out.println("В коробку положили: " + thing);
            }
        }
    }

    public void get(String thing) {
        if (isOpen) {
            if (!isEmpty) {
                System.out.println("Из коробки взяли: " + thing);
            }
        }
    }


    public void repaint(String color) {
        System.out.println("Коробка перекрашена в цвет: " + color);
    }

    public void info() {
        System.out.println("Размеры коробки: длина - " + length + "; ширина - " + width + "; высота - " + height);
        System.out.println("Цвет коробки: " + color);
    }


}
