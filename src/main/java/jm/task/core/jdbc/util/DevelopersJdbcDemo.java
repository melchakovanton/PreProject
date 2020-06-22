//package jm.task.core.jdbc.util;
//
//
//import java.sql.*;
//
//public class DevelopersJdbcDemo {
//    /**
//     * JDBC Driver and database url
//     */
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/prep?autoReconnect=true&useSSL=false&serverTimezone=UTC";
//
//    /**
//     * User and Password
//     */
//    static final String USER = "root";
//    static final String PASSWORD = "09877890";
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Connection connection = null;
//        Statement statement = null;
//
//        System.out.println("Registering JDBC driver...");
//
//        Class.forName(JDBC_DRIVER);
//
//        System.out.println("Creating database connection...");
//        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
//
//        System.out.println("Executing statement...");
//        statement = connection.createStatement();
//
//        String sql = "CREATE TABLE if NOT EXISTS users (\n" +
//                "    id INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
//                "    name VARCHAR(30), \n" +
//                "    lastName VARCHAR(30), \n" +
//                "    age INTEGER\n" +
//                ");";
//
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        System.out.println("Retrieving data from database...");
//        System.out.println("\nDevelopers:");
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            String specialty = resultSet.getString("specialty");
//            int salary = resultSet.getInt("salary");
//
//            System.out.println("\n================\n");
//            System.out.println("id: " + id);
//            System.out.println("Name: " + name);
//            System.out.println("Specialty: " + specialty);
//            System.out.println("Salary: $" + salary);
//        }
//
//        System.out.println("Closing connection and releasing resources...");
//        resultSet.close();
//        statement.close();
//        connection.close();
//    }
//}