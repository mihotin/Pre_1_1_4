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


//        UserDao users = new UserDaoJDBCImpl();
//        users.createUsersTable();
//        users.getAllUsers();
//        System.out.println();
//        System.out.println("--------------------------");
//        users.saveUser("Вася", "Пупкин", (byte) 18);
//        users.saveUser("Вася", "Пупкин", (byte) 18);
//        users.saveUser("Вася", "Пупкин", (byte) 18);
//        users.saveUser("Вася", "Пупкин", (byte) 18);
//        System.out.println("--------------------------");
//        users.getAllUsers();
//        System.out.println("--------------------------");
//        //users.removeUserById(99);
//        users.getAllUsers();
//        System.out.println("--------------------------");
//        // users.cleanUsersTable();

    }
}
