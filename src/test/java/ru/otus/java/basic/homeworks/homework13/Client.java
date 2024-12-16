package ru.otus.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 12345)) {

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Получено от сервера: " + message);

                System.out.println("Введи 3 значения через ентер: два числа и операцию над ними ");
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                char operation = scanner.next().charAt(0);

                out.writeInt(num1);
                out.writeInt(num2);
                out.writeChar(operation);

                int result = in.readInt();
                if (result == Integer.MIN_VALUE) {
                    System.out.println("Ошибка: деление на ноль");
                } else {
                    System.out.println("Result: " + result);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}