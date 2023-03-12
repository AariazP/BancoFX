package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.application.Main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
    public Double consultarSaldo() {
        return null;
    }

    @Override
    public void crearEmpleado() {

    }

    @Override
    public void actualizarEmpleado() {

    }

    @Override
    public void eliminarEmpleado() {

    }

    @Override
    public void obtenerEmpleado() {

    }

    @Override
    public void crearCliente(Cliente cliente) {
        listaClientes.add(cliente);
        listaCuentas.put((cliente.getCedula()+""), cliente.getCuenta());
    }



    @Override
    public void actualizarCliente() {

    }

    @Override
    public void eliminarCliente() {

    }

    @Override
    public void obtenerCliente() {

    }

    @Override
    public void realizarTransaccion() {

    }

    @Override
    public double retirarDineroCuenta() {
        return 0;
    }

    @Override
    public void depositarDineroCuenta() {

    }

    public void mostrarVentana(String ruta) throws Exception {

        main.loadStage(ruta);
    }

    public Cliente loginCliente(String correo, String password){

        for (Cliente cliente : listaClientes) {
            if (cliente.isCliente(correo, password)) {
                return cliente;
            }
        }

        return null;
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
