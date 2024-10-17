package ru.otus.java.basic.homeworks.homework1;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите число от 1 до 5");
        int n = scanner.nextInt();

        int a = -10 + (int) (Math.random() * 10);
        int b = -10 + (int) (Math.random() * 10);
        int c = -10 + (int) (Math.random() * 10);


        if (n == 1) {
            greetings();
        } else if (n == 2) {
            checkSign(a, b, c);
        } else if (n == 3) {
            selectColor();
        } else if (n == 4) {
            compareNumbers();
        } else if (n == 5) {
            addOrSubtractAndPrint(a, b, true);
            addOrSubtractAndPrint(a, b, false);
        }
    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 12;

        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 15;

        if (a > b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            initValue += delta;
        } else {
            initValue -= delta;
        }

        System.out.println(initValue);
    }

}
