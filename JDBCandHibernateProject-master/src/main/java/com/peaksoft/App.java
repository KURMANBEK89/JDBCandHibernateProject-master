package com.peaksoft;


import com.peaksoft.dao.UserDaoJdbcImpl;

public class App
{
    public static void main( String[] args )
    {
        // реализуйте алгоритм здесь
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.createUsersTable();
        userDaoJdbc.saveUser("Kurmanbek", "Mambetomurov", (byte) 33);
        userDaoJdbc.saveUser("Amina","Jalilova", (byte) 29);
        userDaoJdbc.getAllUsers();
        userDaoJdbc.removeUserById(1);
        userDaoJdbc.cleanUsersTable();
        userDaoJdbc.dropUsersTable();
    }
}
