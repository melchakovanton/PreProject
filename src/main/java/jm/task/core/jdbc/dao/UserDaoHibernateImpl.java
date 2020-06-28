package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;

import java.sql.Connection;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    private static UserDaoHibernateImpl userDaoHibernate;
    private static Session session;
    private SessionFactory sessionFactory;

    private UserDaoHibernateImpl() {
        this.sessionFactory = Util.getSessionFactory();
    }

    public static UserDaoHibernateImpl getInstance() {
        if (userDaoHibernate == null) {
            return new UserDaoHibernateImpl();
        }
        return userDaoHibernate;
    }

    @Override
    public void createUsersTable() {
        session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
                "    name VARCHAR(30), \n" +
                "    lastName VARCHAR(30), \n" +
                "    age INTEGER\n" +
                ");");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("DROP TABLE IF EXISTS users");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE User WHERE id = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public void cleanUsersTable() {
        session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE User").executeUpdate();
        transaction.commit();
        session.close();
    }
}
