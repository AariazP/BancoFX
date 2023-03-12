package org.example.model;

public interface IBanco {


    void crearEmpleado(Empleado empleado);
    void actualizarEmpleado(Empleado empleado);
    void eliminarEmpleado(Empleado empleado);

    void crearCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);
    void realizarTransaccion(Transaccion transaccion);


}
