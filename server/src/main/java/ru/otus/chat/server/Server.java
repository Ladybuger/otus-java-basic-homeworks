package ru.otus.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private AuthenticatedProvider authenticatedProvider;

    public Server(int port) throws SQLException {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
        authenticatedProvider = new InDatabaseAuthenticatedProvider(this);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            authenticatedProvider.initialize();
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage("Из чата вышел: " + clientHandler.getUsername());
    }

    public void unsubscribeClientByUsername(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                clients.remove(client);
                broadcastMessage("Администратором из чата удален: " + username);
                break;
            }
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void personaMessage(String user, String message){
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(user)) {
                c.sendMsg(message);
            }
        }
    }

    public boolean isUsernameBusy(String usedrname) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(usedrname)) {
                return true;
            }
        }
        return false;
    }

    public AuthenticatedProvider getAuthenticatedProvider() {
        return authenticatedProvider;
    }
}
