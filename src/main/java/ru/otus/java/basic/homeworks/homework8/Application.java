package ru.otus.java.basic.homeworks.homework8;

public class Application {

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = sumArrayElements(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (AppArraySizeException e) {
            System.err.println("Исключение: " + e.getMessage());
        } catch (AppArrayDataException e) {
            System.err.println("Исключение: " + e.getMessage());
        }
    }

    public static int sumArrayElements(String[][] array) {
        if (array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4) {
            throw new AppArraySizeException("Неверный размер массива");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}

class AppArraySizeException extends RuntimeException {
    public AppArraySizeException(String message) {
        super(message);
    }
}

class AppArrayDataException extends RuntimeException {
    public AppArrayDataException(String message) {
        super(message);
    }
}
