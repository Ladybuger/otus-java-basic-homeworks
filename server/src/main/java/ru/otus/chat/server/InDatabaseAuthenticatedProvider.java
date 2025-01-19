package ru.otus.chat.server;

import java.sql.SQLException;
import java.util.List;

public class InDatabaseAuthenticatedProvider implements AuthenticatedProvider {

    private UserServiceJDBCImpl userService;
    private Server server;
    private List<User> users;

    public InDatabaseAuthenticatedProvider(Server server) throws SQLException {
        this.userService = new UserServiceJDBCImpl();
        this.users = userService.getAll();
    }
    @Override
    public void initialize() {
        System.out.println("Инициализация InDatabaseAuthenticatedProvider");
    }


    private String getUsernameByLoginAndPassword(String login, String password) {
        for (User user : users) {
            if (user.getMail().equals(login) && user.getPassword().equals(password)) {
                return String.valueOf(user.getId());
            }
        }
        return null;
    }

    private Role getRoleByLogin(String login) {
        for (User user : users) {
            if (user.getMail().equals(login)) {
                return user.getRoles().get(0);
            }
        }
        return null;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUsernameByLoginAndPassword(login, password);
        if (authUsername == null) {
            clientHandler.sendMsg("Неверный логин/пароль");
            return false;
        }
        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        clientHandler.setUsername(authUsername);
        clientHandler.setRole(getRoleByLogin(login));
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername);

        return true;
    }

}
