package ru.otus.java.basic;

import java.util.List;

public interface UserServiceJDBC {
    List<User> getAll();

    boolean isAdmin(int userId);
}