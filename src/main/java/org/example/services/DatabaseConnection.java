package org.example.services;

import java.sql.*;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static final String URL = "jdbc:mysql://localhost:3306/escuela_DB";
    private static final String USER ="root";
    private static final String PASSWORD ="1234jose";
    private Connection connection;

    private DatabaseConnection(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + URL + " ... Ok");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static DatabaseConnection getInstance(){
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /**
     * Metodo que permite hacer una consulta a la base de datos.
     */

    public boolean iniciarSesion(String query) throws SQLException {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
