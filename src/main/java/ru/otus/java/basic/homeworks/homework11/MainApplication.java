package ru.otus.java.basic.homeworks.homework11;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        int[] array1 = {12,45,2,5,66,56,45,3,1};
        System.out.println("Массив до сортировки: " + Arrays.toString(array1));

        SortingAlgorithms.bubbleSort(array1);
        System.out.println("Массив после сортировки методом пузырька: " + Arrays.toString(array1));

        int[] array2 = {77,76,54,53,62,51,45,32,11};
        System.out.println("Массив до сортировки: " + Arrays.toString(array2));

        SortingAlgorithms.quickSort(array2);
        System.out.println("Массив после сортировки методом пузырька: " + Arrays.toString(array2));
    }

}
