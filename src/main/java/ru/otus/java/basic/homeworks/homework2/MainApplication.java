package ru.otus.java.basic.homeworks.homework2;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr1 = {1,2,3,1,1,1};

        printString(5, "Hello World");
        sumElements(1,2,6,7,5);
        fillNumber(6, arr);
        System.out.println(Arrays.toString(arr));
        increaseValue(1, arr);
        System.out.println(Arrays.toString(arr));
        checkSum(arr1);
        flipArray(arr1);


    }
    public static void printString(int n, String str) {

        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static void sumElements(int... arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
           if (arr[i] > 5) {
               sum += arr[i];
           }
        }

        System.out.println(sum);
    }

    public static void fillNumber(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
        }
    }

    public static void increaseValue(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += n;
        }
    }

    public static void checkSum(int[] arr1) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arr1.length/2; i++) {
            sum1 += arr1[i];
        }

        for (int i = arr1.length/2; i < arr1.length/2; i++) {
            sum2 += arr1[i];
        }

        if (sum1 > sum2) {
            System.out.println("Сумма элементов первой половины массива больше");
        } else if (sum1 < sum2) {
            System.out.println("Сумма элементов второй половины массива больше");
        } else {
            System.out.println("Суммs элементов первой и второй половины массива равны");
        }
    }

    // *Метод, переворачивающий входящий массив
    public static void flipArray(int[] arr1) {
        for (int i = arr1.length - 1; i >= 0; i--) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

}
