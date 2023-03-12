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

    public Cliente() {}

    public Cliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String contrasenia) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, contrasenia);
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
}
