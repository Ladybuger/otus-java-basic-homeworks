package ru.otus.java.basic.homeworks.homework4;

public class Box {
    private int length, width, height;
    private String color;
    private boolean isEmpty;
    private boolean isOpen;

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

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public boolean getIsEmpty () { return isEmpty; }
    public void setIsEmpty(boolean isEmpty) { this.isEmpty = isEmpty; }

    public boolean getIsOpen () { return isOpen; }
    public void setIsOpen(boolean isOpen) { this.isOpen = isOpen; }


    public Box (int length, int width, int height, String color, boolean isEmpty) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isEmpty = isEmpty;
    }

    public void open() {
        isOpen = true;
        System.out.println("Коробку открыли");
    }

    public void close() {
        isOpen = false;
        System.out.println("Коробку закрыли");
    }

    public void put() {
        if (!isOpen) {
            System.out.println("Коробка закрыта");
            return;
        }

        if (isEmpty) {
            System.out.println("В коробку положили предмет");
        } else {
            System.out.println("В коробке уже есть предмет");
        }
    }

    public void get() {
        if (!isOpen) {
            System.out.println("Коробка закрыта");
            return;
        }

        if (!isEmpty) {
            System.out.println("Из коробки взяли предмет");
        } else {
            System.out.println("В коробке пусто");
        }
    }

    public void repaint(String color) {
        this.color = color;
        System.out.println("Коробка перекрашена в цвет: " + color);
    }

    public void info() {
        System.out.println("Размеры коробки: длина - " + length + "; ширина - " + width + "; высота - " + height);
        System.out.println("Цвет коробки: " + color);
    }


}
