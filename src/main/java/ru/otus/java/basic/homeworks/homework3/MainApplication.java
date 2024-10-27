package ru.otus.java.basic.homeworks.homework3;

public class MainApplication {
    public static void main(String[] args) {
        int[][] array2D = {{-1,2,0}, {4,5,6}, {3,3,4}};
        //1
        System.out.println(sumOfPositiveElements(array2D));
        //2
        printSquareSpecifiedSize(3);
        //4
        System.out.println(findMax(array2D));
        //5
        System.out.println(sumRowElements2DArray(array2D));
        //3
        zeroDiagonals2DArray(array2D);
    }

    public static int sumOfPositiveElements(int[][] array) {
        int sumElements = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    sumElements += array[i][j];
                }
            }
        }
        return sumElements;
    }

    public static void printSquareSpecifiedSize(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*" + " ");
            }
        System.out.println();
        }
    }

    public static void zeroDiagonals2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 0;
                }

                if (i + j == array.length - 1) {
                    array[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] array) {
        int maxElement = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxElement) {
                    maxElement = array[i][j];
                }
            }
        }
        return maxElement;
    }

    public static int sumRowElements2DArray(int[][] array) {
        int sumElements = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 2) {
                    sumElements += array[i][j];
                }
            }
        }

        if (sumElements > 0) {
            return sumElements;
        }

        return -1;
    }
}
