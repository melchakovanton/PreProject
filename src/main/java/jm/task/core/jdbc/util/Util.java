package jm.task.core.jdbc.util;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.*;
import java.util.Collection;
// реализуйте настройку соеденения с БД
public class Util {

    public static Connection getMysqlConnection() {
        String URL = "jdbc:mysql://localhost:3306/preproject?serverTimezone=UTC";
        String User = "root";
        String PASSWORD = "09877890";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, User, PASSWORD);
            return connection;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }

//        try {
//            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
//
//            StringBuilder url = new StringBuilder();
//
//            url.
//                    append("jdbc:mysql://").        //db type
//                    append("localhost:").           //host name
//                    append("3306/").                //port
//                    append("preproject?serverTimezone=UTC&").                //db name
//                    append("user=root&").            //login
//                    append("password=09877890");    //password
//
//            System.out.println("URL: " + url + "\n");
//
//            Connection connection = DriverManager.getConnection(url.toString());
//            return connection;
//        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new IllegalStateException();
//        }
    }
}
