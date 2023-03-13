package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
@Getter
@Setter
public class Empleado extends Persona implements Comparable<Empleado>{

    private String codigo;
    private Double salario;
    private LinkedList<Cliente> listaClienteAsociados;
    private Banco banco;
    private Long identificador;
    private static Long idEmp = 0L;
    public Empleado() {}

    public Empleado(String codigo, double salario) {
        listaClienteAsociados = new LinkedList<>();
        this.codigo = codigo;
        this.salario = salario;
        listaClienteAsociados = new LinkedList<>();
    }

    public Empleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String contrasenia, Double salario) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, contrasenia);
        //this.codigo = codigo;
        this.salario = salario;
        listaClienteAsociados = new LinkedList<>();
        identificador = ++idEmp;
    }

    @Override
    public int compareTo(Empleado o) {
        return o.getNombre().compareTo(this.getNombre());
    }

    public boolean isEmpleado(String email, String password) {
        return this.getCorreo().equals(email) && this.getContrasenia().equals(password);
    }
}
