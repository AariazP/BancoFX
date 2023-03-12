package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.example.utils.Utils;

@Getter
@Setter
public class LoginController extends Controller{

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnCrear;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPaswd;

    @FXML
    void loguearse(ActionEvent event) {

    }

    @FXML
    void crearCuenta(ActionEvent event) throws Exception {

        banco.mostrarVentana(Utils.Crear);
    }

}
