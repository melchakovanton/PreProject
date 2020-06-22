package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    private SessionFactory sessionFactory;

    public UserServiceImpl() {
        this.sessionFactory = Util.getSessionFactory();
    }

    @Override
    public void createUsersTable() {
//        getUserDaoJDBC().createUsersTable();
        getUserDaoHibernate().createUsersTable();
    }

    public void dropUsersTable() {
//        getUserDaoJDBC().dropUsersTable();
        getUserDaoHibernate().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
//        getUserDaoJDBC().saveUser(name, lastName, age);
        getUserDaoHibernate().saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
//        getUserDaoJDBC().removeUserById(id);
        getUserDaoHibernate().removeUserById(id);
    }

    public List<User> getAllUsers() {
//        return getUserDaoJDBC().getAllUsers();
        return getUserDaoHibernate().getAllUsers();
    }

    public void cleanUsersTable() {
//        getUserDaoJDBC().cleanUsersTable();
        getUserDaoHibernate().cleanUsersTable();
    }

    private static UserDaoJDBCImpl getUserDaoJDBC() {
        return new UserDaoJDBCImpl(Util.getMysqlConnection());
            }

    private static UserDaoHibernateImpl getUserDaoHibernate() {
        return new UserDaoHibernateImpl(Util.getSessionFactory().openSession());
    }


}
