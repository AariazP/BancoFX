package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Cliente extends Persona implements Comparable<Cliente>{

    private Empleado empleadoAsociado;
    private  Banco banco;

    private Cuenta cuenta;

    private Long identificador;

    private static Long idCliente = 0L;

    public Cliente() {}


    public Cliente(String name, String lastName, String telefono, String email, String id, String address, String password, String numCuenta, String fecha, Double saldo, String tipo) {

        super(name, lastName, id, address, telefono, email, fecha, password);
        crearCuenta(numCuenta, saldo, tipo);

        identificador = ++idCliente;

    }

    private void crearCuenta(String numCuenta, Double saldo, String tipo) {

        if(tipo.equals("Cuenta Ahorros")) cuenta = new CuentaAhorro(numCuenta, saldo);
        else cuenta = new CuentaCorriente(numCuenta, saldo);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(empleadoAsociado, cliente.empleadoAsociado) && Objects.equals(banco, cliente.banco) && Objects.equals(cuenta, cliente.cuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoAsociado, banco, cuenta);
    }

    @Override
    public int compareTo(Cliente o) {return this.getCedula().compareTo(o.getCedula());}

    public boolean isCliente(String correo, String password) {
        return this.getCorreo().equals(correo) && this.getContrasenia().equals(password);
    }

    public boolean isAhorros() {
        return cuenta instanceof CuentaAhorro;
    }
}
