package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.model.Cliente;
import org.example.utils.Utils;

public class ClienteController extends Controller {

    @FXML
    private Label labelNum;

    @FXML
    private Label labelSaldo;

    @FXML
    private Label labelTipo;

    @FXML
    private TextField txtSaldoConsignar;

    @FXML
    private TextField txtSaldoRetiro;
    private Double saldoConsignar;
    private Double saldoRetiro;


    @FXML
    void depositarDinero(ActionEvent ignoredEvent) {

        if(cargarSaldoConsignar()){
            Cliente activo = (Cliente) main.getPersonaActiva();
            activo.getCuenta().consignar(saldoConsignar);
            main.mostrarMensaje("Consignacion exitosa", "Consignacion exitosa", "Se ha consignado exitosamente el dinero a su cuenta",
                    Alert.AlertType.INFORMATION);
            cargarSaldo();
            txtSaldoConsignar.setText("");
            txtSaldoRetiro.setText("");
        }



    }

    public boolean cargarSaldoConsignar(){
        try {
            saldoConsignar = Double.parseDouble(txtSaldoConsignar.getText());
            return true;
        } catch (NumberFormatException e) {
            main.mostrarMensaje("Error", "Error", "El valor ingresado no es valido", Alert.AlertType.ERROR);
            return false;
        }



    }


    @FXML
    void retirarDinero(ActionEvent ignoredEvent) {

        if(cargarSaldoRetiro()){
            Cliente activo = (Cliente) main.getPersonaActiva();
            if(activo.getCuenta().getSaldo() >= saldoRetiro){
                activo.getCuenta().retirar(saldoRetiro);
                main.mostrarMensaje("Retiro exitoso", "Retiro exitoso", "Se ha retirado exitosamente el dinero de su cuenta",
                        Alert.AlertType.INFORMATION);
                cargarSaldo();
            }else{
                main.mostrarMensaje("Error", "Error", "No tiene saldo suficiente para realizar el retiro", Alert.AlertType.ERROR);
            }
            txtSaldoRetiro.setText("");
            txtSaldoConsignar.setText("");

        }

        cargarSaldo();

    }

    private boolean cargarSaldoRetiro(){
        try {
            saldoRetiro = Double.parseDouble(txtSaldoRetiro.getText());
            return true;
        } catch (NumberFormatException e) {
            main.mostrarMensaje("Error", "Error", "El valor ingresado no es valido", Alert.AlertType.ERROR);
            return false;
        }
    }



    @FXML
    void salir(ActionEvent ignoredEvent) throws Exception {
        main.loadStage(Utils.Login);
    }



    public void cargarSaldo() {
        Cliente activo = (Cliente) main.getPersonaActiva();
        labelSaldo.setText(activo.getCuenta().getSaldo() + "");
        labelNum.setText(activo.getCuenta().getNumeroCuenta());
        if(activo.isAhorros()){
            labelTipo.setText("Savings Account");
        }else{
            labelTipo.setText("Current Account");
        }
    }
}
