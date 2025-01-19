package ru.otus.chat.server;

import ru.otus.chat.server.User;

import java.util.List;

public interface UserServiceJDBC {
    List<User> getAll();
}