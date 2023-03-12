package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaAhorro extends Cuenta{

    public CuentaAhorro(String numeroCuenta, Double saldo) {
        super(numeroCuenta, saldo);
    }
}
