package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transaccion {

    private String fecha;
    private String hora;
    private Double valor;
    private Banco banco;

    public Transaccion() {
    }

    public Transaccion(String fecha, String hora, Double valor) {
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
    }

}
