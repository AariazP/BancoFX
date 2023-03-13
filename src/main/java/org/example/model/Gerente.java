package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gerente extends Empleado{

    public Gerente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String contrasenia, Double salario) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, contrasenia, salario);
    }
}
