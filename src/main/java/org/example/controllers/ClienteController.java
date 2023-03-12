package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.utils.Utils;

public class ClienteController extends Controller {
    

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
        main.loadStage(Utils.Login);
    }


}


