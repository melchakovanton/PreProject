package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.util.List;

public class Main {
    private final static UserService userService = UserServiceImpl.getInstance();


    //Сделать Синглтон из сервиса
    public static void main(String[] args) {

        userService.createUsersTable();

        userService.saveUser("Tom", "Reddle", (byte) 54);
        System.out.println("User с именем Tom добавлен в базу данных");
        userService.saveUser("Harry", "Potter", (byte) 24);
        System.out.println("User с именем Harry добавлен в базу данных");
        userService.saveUser("Ron", "Whisley", (byte) 24);
        System.out.println("User с именем Ron добавлен в базу данных");
        userService.saveUser("Hermiona", "Granger", (byte) 24);
        System.out.println("User с именем Hermiona добавлен в базу данных");

        List<User> list = userService.getAllUsers();
        for (User user : list) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
