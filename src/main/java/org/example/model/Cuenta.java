package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Objects;
@Getter
@Setter
public class Cuenta implements ICuenta{

    private String numeroCuenta;
    private Double saldo;
    private Banco banco;



    private LinkedList<Transaccion> listaTransacciones;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, Double saldo) {
        listaTransacciones = new LinkedList<>();
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(numeroCuenta, cuenta.numeroCuenta) && Objects.equals(saldo, cuenta.saldo) && Objects.equals(banco, cuenta.banco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCuenta, saldo, banco);
    }

    @Override
    public void consignar(Double saldoConsignar) {
        saldo += saldoConsignar;
    }
    @Override
    public void retirar(Double saldoRetiro) {
        saldo -= saldoRetiro;
    }
}
