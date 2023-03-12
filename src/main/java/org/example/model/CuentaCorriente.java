package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class CuentaCorriente extends Cuenta{

    public CuentaCorriente(String numeroCuenta, Double saldo) {
        super(numeroCuenta, saldo);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
