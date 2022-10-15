package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Саша", "Батырев", (byte) 18);
        userService.saveUser("Андрей", "Кирдяпкин", (byte) 20);
        userService.saveUser("Алексей", "Хрупало", (byte) 22);
        userService.saveUser("Борис", "Манджиев", (byte) 50);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}