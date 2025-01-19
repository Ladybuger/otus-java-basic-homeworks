package ru.otus.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;


public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;

    private String username;
    private UserRole role;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился на порту: " + socket.getPort());
                //цикл аутентификации
                while (true) {
                    sendMsg("Для начала работы надо пройти аутентификацию. Формат команды /auth login password \n" +
                            "или регистрацию. Формат команды /reg login password username ");

                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        // /auth login password
                        if (message.startsWith("/auth ")) {
                            String[] element = message.split(" ");
                            if (element.length != 3){
                                sendMsg("Неверный формат команды /auth");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .authenticate(this, element[1], element[2])){

                                break;
                            }
                        }
                    }
                }
                //цикл работы
                while (true) {
                    String message = in.readUTF();
                    String[] words = message.split(" ", 3);
                    System.out.println(Arrays.toString(words));
                    if (words[0].startsWith("/")) {
                        if (words[0].startsWith("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        if (words[0].startsWith("/w")) {
                            server.personaMessage(words[1], "private message " + username + " : " + words[2]);
                        }
                    } else {
                        server.broadcastMessage(username + " : " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
