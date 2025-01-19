package ru.otus.chat.server;

import java.util.List;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login, String password );
}
