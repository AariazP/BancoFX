package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(String numeroCuenta, Double saldo) {
        super(numeroCuenta, saldo);
    }
}
