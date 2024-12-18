package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3300/hotel"; 
    private static final String USER = "root";
    private static final String PASSWORD = "123456"; 
    private static Connection connection;

    private SingleConnection() {}

    private static void initConnection() {
        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion � la base de donn�es �tablie avec succ�s.");
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC non trouv�.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("�chec de l'�tablissement de la connexion � la base de donn�es.");
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (connection == null) {
            initConnection(); 
        }
        return connection;
    }
}