package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
@Getter
@Setter
public class Empleado extends Persona implements Comparable<Empleado>{

    private String codigo;
    private String salario;
    private LinkedList<Cliente> listaClienteAsociados;
    private Banco banco;

    public Empleado() {}

    public Empleado(String codigo, String salario) {
        listaClienteAsociados = new LinkedList<>();
        this.codigo = codigo;
        this.salario = salario;
    }

    @Override
    public int compareTo(Empleado o) {
        return o.getNombre().compareTo(this.getNombre());
    }

    public boolean isEmpleado(String email, String password) {
        return this.getCorreo().equals(email) && this.getContrasenia().equals(password);
    }
}
