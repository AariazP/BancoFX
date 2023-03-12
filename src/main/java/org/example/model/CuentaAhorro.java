package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CuentaAhorro extends Cuenta{

    public CuentaAhorro(String numeroCuenta, Double saldo) {
        super(numeroCuenta, saldo);
    }
}
