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
    public void crearCliente() {

    }

    public void crearhCliente(String nomb, String id, String apd, String direc, String telefono, String email,
                             String fecha, String contra, double saldo, String tipoCuenta, String numCuenta) {

        Cliente a = new Cliente(nomb, apd, id, direc, telefono, email, fecha, contra);
        Cuenta b;
        if(tipoCuenta == "Cuenta Ahorros"){
             b = new CuentaAhorro(numCuenta, saldo);
             b.setEsA(true);
        }else{

            b = new CuentaCorriente(numCuenta, saldo);
        }
        a.setCuenta(b);
        listaClientes.add(a);
        listaCuentas.put("", b);
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

    public Cliente loguearCliente(String correo, String contra){

        Iterator<Cliente> it = listaClientes.iterator();

        while(it.hasNext()){
            Cliente c = it.next();
            if(c.getCorreo().equals(correo)){
                if(c.getContrasenia().equals(contra))return c;
            }
        }

        return null;
    }
}
