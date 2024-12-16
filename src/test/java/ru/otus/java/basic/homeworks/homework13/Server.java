package ru.otus.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Сервер запущен. Ожидание подключения клиента...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключен");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            out.writeUTF("возможные операции над числами: +, -, *, /");

            int num1 = in.readInt();
            int num2 = in.readInt();
            char operation = in.readChar();

            int result = numberOperation(num1, num2, operation);

            out.writeInt(result);
            System.out.println(result);

            in.close();
            out.close();
            clientSocket.close();
        }
    }

    private static int numberOperation(int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    result = -1;
                }
                break;
        }
        return result;
    }
}