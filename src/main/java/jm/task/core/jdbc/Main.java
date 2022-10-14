package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Вася", "Пупкин", (byte) 18);
        userService.saveUser("Петя", "Оля", (byte) 20);
        userService.saveUser("Аня", "Таня", (byte) 22);
        userService.getAllUsers();
    }
}
