package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.model.Cliente;
import org.example.utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class ClienteController extends Controller implements Initializable {

    @FXML
    private Label labelNum;

    @FXML
    private Label labelSaldo;

    @FXML
    private Label labelTipo;


    @FXML
    private Button btnDeposito;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnRetiro;

    @FXML
    private TextField txtSaldoMod;


    @FXML
    void depositarDinero(ActionEvent event) {

    }

    @FXML
    void retirarDinero(ActionEvent event) {

    }
    @FXML
    void salir(ActionEvent event) throws Exception {

        banco.mostrarVentana(Utils.Login);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Cliente activo = banco.getClienteActivo();
        labelSaldo.setText(activo.getCuenta().getSaldo() + "");
        labelNum.setText(activo.getCuenta().getNumeroCuenta());
        if(activo.getCuenta().isEsA()){
            labelTipo.setText("Savings Account");
        }else{

            labelTipo.setText("Current Account");
        }
    }
}
