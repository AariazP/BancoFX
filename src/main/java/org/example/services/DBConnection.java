package org.example.services;

import org.example.model.Cliente;

import java.sql.*;

public class DBConnection {

    private static DBConnection instance;
    private static final String URL = "jdbc:mysql://MYSQL8003.site4now.net/db_a96001_bancoed";
    private static final String USER = "a96001_bancoed";
    private static final String PASSWORD = "ed1-banco";
    private Connection connection;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Conexión a base de datos " + URL + " ... Ok");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static DBConnection getInstance() {
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

    public void agregarCliente(Cliente cliente) throws SQLException {
        try {
            String sql = "INSERT INTO clientes (identificador, nombre, apellido, cedula, direccion, telefono," +
                    " correo, contrasena, fechaNacimiento, cuenta) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparación de la consulta SQL con los valores del cliente
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cliente.getIdentificador());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getApellido());
            pstmt.setString(4, cliente.getCedula());
            pstmt.setString(5, cliente.getDireccion());
            pstmt.setString(6, cliente.getTelefono());
            pstmt.setString(7, cliente.getCorreo());
            pstmt.setString(8, cliente.getContrasenia());
            pstmt.setString(9, cliente.getFechaNacimiento());
            pstmt.setString(10, cliente.getCuenta().toString());
            // Ejecución de la consulta SQL
            pstmt.executeUpdate();
            // Cierre de la conexión y del statement
            pstmt.close();
            System.out.println(" Cliente agregado a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al agregar el cliente a la base de datos: " + e.getMessage());
        }

    }


}
