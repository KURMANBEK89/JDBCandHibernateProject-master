package com.peaksoft;


import com.peaksoft.dao.UserDaoHibernateImpl;
import com.peaksoft.dao.UserDaoJdbcImpl;

public class App
{
    public static void main( String[] args )
    {
//        // реализуйте алгоритм здесь
//        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
//        userDaoJdbc.createUsersTable();
//        userDaoJdbc.saveUser("Kurmanbek", "Mambetomurov", (byte) 33);
//        userDaoJdbc.saveUser("Amina","Jalilova", (byte) 29);
//        System.out.println(userDaoJdbc.getAllUsers());
//        userDaoJdbc.removeUserById(1);
//        userDaoJdbc.cleanUsersTable();
//        userDaoJdbc.dropUsersTable();

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Kurmanbek","Mambetomurov",(byte) 33);
        userDaoHibernate.saveUser("Amina","Jalilova",(byte)29);
        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.removeUserById(1);
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();
    }

}
