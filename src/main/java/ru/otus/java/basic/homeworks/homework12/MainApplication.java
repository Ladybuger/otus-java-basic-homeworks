package ru.otus.java.basic.homeworks.homework12;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.*;


public class MainApplication {
    public static void main(String[] args) {
        File directory = new File(".");
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("В текущем каталоге нет файлов");
            return;
        }

        System.out.println("Список файлов:");
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println(file.getName());
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите полное имя файла с расширением .txt: ");
        String fileName = scanner.nextLine();

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
            int n = in.read();
            while (n != -1) {
                System.out.print((char)n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Введите строку для записи в файл: ");
        String input = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (new File(fileName).length() != 0) {
                writer.newLine(); // Добавляем переход на новую строку, если файл не пустой
            }
            writer.write(input);
            System.out.println("Строка успешно записана в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
