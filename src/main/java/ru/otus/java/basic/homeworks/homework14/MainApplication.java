package ru.otus.java.basic.homeworks.homework14;

public class MainApplication {
    public static void main(String[] args) {
        long startTime1Thread = System.currentTimeMillis();
        fillArray1Thread();
        long endTime1Thread = System.currentTimeMillis();
        System.out.println("Заполнение массива в один поток: " + (endTime1Thread - startTime1Thread) + "мс");

        long startTime4Threads = System.currentTimeMillis();
        fillArray4Threads();
        long endTime4Threads = System.currentTimeMillis();
        System.out.println("Заполнение массива в четыре потока: " + (endTime4Threads - startTime4Threads) + "мс");
    }

    private static void fillArray1Thread() {
        double[] array = new double[100_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    public static void fillArray4Threads() {
        double[] array = new double[100_000_000];
        int quarter = array.length / 4;
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < quarter; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = quarter; i < 2 * quarter; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 2 * quarter; i < 3 * quarter; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 3 * quarter; i < array.length; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
