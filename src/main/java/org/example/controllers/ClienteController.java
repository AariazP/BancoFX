package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private TextField txtSaldo;

    private Double saldo;

    @FXML
    void depositarDinero(ActionEvent ignoredEvent) {

        if(verificarSaldo()){
            Cliente activo = (Cliente) main.getPersonaActiva();
            activo.getCuenta().consignar(saldo);
            main.mostrarMensaje("Consignacion exitosa", "Consignacion exitosa", "Se ha consignado exitosamente el dinero a su cuenta",
                    Alert.AlertType.INFORMATION);
            cargarSaldo();
            txtSaldo.setText("");
        }
    }

    public boolean verificarSaldo(){
        try {
            saldo = Double.parseDouble(txtSaldo.getText());
            return true;
        } catch (NumberFormatException e) {
            main.mostrarMensaje("Error", "Error", "El valor ingresado no es valido", Alert.AlertType.ERROR);
            return false;
        }
    }


    @FXML
    void retirarDinero(ActionEvent ignoredEvent) {

        if(verificarSaldo()){
            Cliente activo = (Cliente) main.getPersonaActiva();
            if(activo.getCuenta().getSaldo() >= saldo){
                activo.getCuenta().retirar(saldo);
                main.mostrarMensaje("Retiro exitoso", "Retiro exitoso", "Se ha retirado exitosamente el dinero de su cuenta",
                        Alert.AlertType.INFORMATION);
                cargarSaldo();
            }else{
                main.mostrarMensaje("Error", "Error", "No tiene saldo suficiente para realizar el retiro", Alert.AlertType.ERROR);
            }
            txtSaldo.setText("");
        }

        cargarSaldo();
    }

    @FXML
    void salir(ActionEvent ignoredEvent) throws Exception {

        main.loadStage(Utils.Login);
    }

    @FXML
    void mostrarEmpleado(MouseEvent event) throws Exception {
        Cliente activo = (Cliente) main.getPersonaActiva();
        main.setPersonaPasiva(activo.getEmpleadoAsociado());
        main.loadStage(Utils.Empleado);
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
