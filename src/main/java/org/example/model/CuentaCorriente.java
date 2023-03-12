package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(String numeroCuenta, Double saldo) {
        super(numeroCuenta, saldo);
    }
}
