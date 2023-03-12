package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.application.Main;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

@Getter
@Setter
public class Banco implements IBanco{

    Main main;

    Cliente clienteActivo;
    private static Banco instance = null;
    private HashSet<Cliente> listaClientes;
    private TreeSet<Empleado> listaEmpleados;
    private HashMap<String, Cuenta> listaCuentas;


    private Banco() {
        listaClientes = new HashSet<>();
        listaEmpleados = new TreeSet<>();
        listaCuentas = new HashMap<>();

    }


    // Singleton
    public static Banco getInstance() {
        if (instance == null) {
            instance = new Banco();
        }
        return instance;
    }



    @Override
    public void crearEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {

        listaEmpleados.forEach(empleado1 -> {
            if (empleado1.equals(empleado)) {
                empleado1.setNombre(empleado.getNombre());
                empleado1.setApellido(empleado.getApellido());
                empleado1.setCorreo(empleado.getCorreo());
                empleado1.setContrasenia(empleado.getContrasenia());
            }
        });

    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        listaEmpleados.removeIf(empleado1 -> empleado1.equals(empleado));
    }


    @Override
    public void crearCliente(Cliente cliente) {
        listaClientes.add(cliente);
        listaCuentas.put((cliente.getCedula()+""), cliente.getCuenta());
    }



    @Override
    public void actualizarCliente(Cliente cliente) {

        listaClientes.forEach(cliente1 -> {
            if (cliente1.equals(cliente)) {
                cliente1.setNombre(cliente.getNombre());
                cliente1.setApellido(cliente.getApellido());
                cliente1.setCorreo(cliente.getCorreo());
                cliente1.setContrasenia(cliente.getContrasenia());
                cliente1.setCuenta(cliente.getCuenta());
            }
        });

    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        listaClientes.removeIf(cliente1 -> cliente1.equals(cliente));

    }


    @Override
    public void realizarTransaccion(Transaccion transaccion) {

    }

    public void mostrarVentana(String ruta) throws Exception {

        main.loadStage(ruta);
    }


    public Persona getPersona(String email, String password) {

        for (Cliente cliente : listaClientes) {
            if (cliente.isCliente(email, password)) {
                return cliente;
            }
        }


        for (Empleado empleado : listaEmpleados) {
            if (empleado.isEmpleado(email, password)) {
                return empleado;
            }
        }

        return null;

    }
}
