package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void createUsersTable() {
        getUserDaoJDBC().createUsersTable();
    }

    public void dropUsersTable() {
        getUserDaoJDBC().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        getUserDaoJDBC().saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        getUserDaoJDBC().removeUserById(id);
    }

    public List<User> getAllUsers() {
        return getUserDaoJDBC().getAllUsers();
    }

    public void cleanUsersTable() {
        getUserDaoJDBC().cleanUsersTable();
    }

    private static UserDaoJDBCImpl getUserDaoJDBC() {
        return new UserDaoJDBCImpl(Util.getMysqlConnection());
    }


}
