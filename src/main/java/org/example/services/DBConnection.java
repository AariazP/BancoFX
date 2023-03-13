package org.example.services;

import org.example.model.*;

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


    public void insertarEmpleado(Empleado empleado) {

        try {
            String sql = "INSERT INTO empleados (identificador, nombre, apellido, cedula, direccion, telefono," +
                    " correo, contrasena, fechaNacimiento, clientesAsociados) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Preparación de la consulta SQL con los valores del cliente
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, empleado.getIdentificador());
            pstmt.setString(2, empleado.getNombre());
            pstmt.setString(3, empleado.getApellido());
            pstmt.setString(4, empleado.getCedula());
            pstmt.setString(5, empleado.getDireccion());
            pstmt.setString(6, empleado.getTelefono());
            pstmt.setString(7, empleado.getCorreo());
            pstmt.setString(8, empleado.getContrasenia());
            pstmt.setString(9, empleado.getFechaNacimiento());
            pstmt.setString(10, empleado.getListaClienteAsociados().toString());
            // Ejecución de la consulta SQL
            pstmt.executeUpdate();
            // Cierre de la conexión y del statement
            pstmt.close();
            System.out.println(" Empleado agregado a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al agregar el empleado a la base de datos: " + e.getMessage());
        }

    }

    //obtener todos los clientes de la base de datos

    public void obtenerClientes()  {
        try {
            String sql = "SELECT * FROM clientes";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdentificador(rs.getLong("identificador"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setCedula(rs.getString("cedula"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setContrasenia(rs.getString("contrasena"));
                cliente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                Cuenta cuenta = obtenerTipoCuenta(rs.getString("cuenta"));
                cliente.setCuenta(cuenta);
                Banco.getInstance().crearCliente(cliente);


            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes de la base de datos: " + e.getMessage());
        }
    }

    private Cuenta obtenerTipoCuenta(String cuentaAux) {
        Cuenta cuenta = null;

        String[] datos = cuentaAux.split(" ");

        if(datos[0].equals("CuentaAhorro")) {
            cuenta = new CuentaAhorro(datos[2], Double.parseDouble(datos[1]));
        }else{
            cuenta = new CuentaCorriente( datos[1] , Double.parseDouble(datos[2]));
        }

        return cuenta;

    }


    public void obtenerEmpleados() {
        try {
            String sql = "SELECT * FROM empleados";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdentificador(rs.getLong("identificador"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setCedula(rs.getString("cedula"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setContrasenia(rs.getString("contrasena"));
                empleado.setFechaNacimiento(rs.getString("fechaNacimiento"));
                empleado.setSalario(rs.getDouble("salario"));
                Banco.getInstance().crearEmpleado(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los empleados de la base de datos: " + e.getMessage());
        }
    }

    public void cargarTodosDatos(){
        obtenerClientes();
        obtenerEmpleados();
    }


}
