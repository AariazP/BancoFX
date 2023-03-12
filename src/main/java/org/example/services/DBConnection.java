package org.example.services;

import java.sql.*;

public class DBConnection {

    private static DBConnection instance;
    private static final String URL = "MYSQL8003.site4now.net";
    private static final String USER ="a96001_bancoed";
    private static final String PASSWORD ="ed1-banco";
    private Connection connection;

    private DBConnection(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + URL + " ... Ok");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static DBConnection getInstance(){
        if (instance == null) {
            instance = new DBConnection();
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
