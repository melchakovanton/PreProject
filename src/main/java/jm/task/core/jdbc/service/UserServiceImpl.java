package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userService;

    //    private final UserDao userDao = UserDaoJDBCImpl.getInstance(Util.getMysqlConnection());
    private final UserDao userDao = UserDaoHibernateImpl.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

//    private static UserDaoJDBCImpl getUserDaoJDBC() {
//        return new UserDaoJDBCImpl(Util.getMysqlConnection());
//    }

//    private static UserDaoHibernateImpl getUserDaoHibernate() {
//        return new UserDaoHibernateImpl(Util.getSessionFactory().openSession());
//    }


}
