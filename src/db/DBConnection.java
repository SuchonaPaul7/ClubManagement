package db;
import java.sql.*;


public class DBConnection {
    //DB connection details
    private static final String URL = "jdbc:mysql://localhost:3306/ClubManagementDB";
    private static final String USER = "root";   //default in XAMPP
    private static final String PASSWORD = "12345677";  //default is empty unless set one


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }



}
