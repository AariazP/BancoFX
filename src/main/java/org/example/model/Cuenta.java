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

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void crearTransaccion(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(numeroCuenta, cuenta.numeroCuenta) && Objects.equals(saldo, cuenta.saldo) && Objects.equals(banco, cuenta.banco);
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public LinkedList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(LinkedList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCuenta, saldo, banco);
    }

    @Override
    public Double retirarDinero() {
        return null;
    }

    @Override
    public void depositarDinero() {

    }

    @Override
    public Double consultarSaldo() {
        return null;
    }
}
