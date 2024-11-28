package ru.otus.java.basic.homeworks.homework8;

public class Application {
    public static void processArray(String[][] array) {
        try {
            if (array.length != 4 || array[0].length != 4) {
                throw new AppArraySizeException("Array size must be 4x4");
            }

        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[][] array = {
                {"a", "b", "c", "d"},
                {"e", "f", "g", "h"},
                {"i", "j", "k", "l"},
                {"m", "n", "o", "p"}
        };

        processArray(array);
    }
}

class AppArraySizeException extends Exception {
    public AppArraySizeException(String message) {
        super(message);
    }

}
