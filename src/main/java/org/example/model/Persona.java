package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Persona {

    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private String contrasenia;
    private String fechaNacimiento;


    public Persona(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
    }

    public Persona() {
    }



}
