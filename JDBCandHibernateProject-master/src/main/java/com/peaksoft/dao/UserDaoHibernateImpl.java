package com.peaksoft.dao;

import com.peaksoft.model.User;
import com.peaksoft.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users(" +
                "id BIGSERIAL PRIMARY KEY," +
                "name VARCHAR(255)," +
                "last_name VARCHAR(255)," +
                "age INT2);";
        Session session = Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery(SQL).executeUpdate();
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS users;";
        Session session = Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery(SQL).executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        Session session = Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);

            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            User u = session.get(User.class, id);
            session.delete(u);
            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        List<User> users = null;
        try {
            session.beginTransaction();
            users = session.createQuery("FROM User").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery("TRUNCATE TABLE users");
            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }
    }
}
