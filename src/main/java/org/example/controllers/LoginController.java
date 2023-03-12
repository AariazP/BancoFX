package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Cliente;
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
    void loguearse(ActionEvent event) throws Exception {

        String email = txtEmail.getText();
        String paswd = txtPaswd.getText();

        if(datosValidos(email, paswd)){

            Cliente cli = banco.loguearCliente(email, paswd);
            if(cli != null){

                banco.setClienteActivo(cli);
                banco.mostrarVentana(Utils.Cliente);
            }else{

                mostrarMensaje("Informacion de login invalida", "Informacion de login invalida", "El usuario que ingreso no esta registrado",
                        Alert.AlertType.WARNING);
                txtEmail.setText("");
                txtPaswd.setText("");
            }
        }
    }

    private boolean datosValidos(String email, String paswd) {

        String notificacionS = "";

        if (email == null || email.equals("")) {

            notificacionS += "Debe ingresar un correo.\n";
        }

        if (paswd == null || paswd.equals("")) {

            notificacionS += "Debe ingresar una contraseña.\n";
        }
        if (notificacionS.equals("")) {
            return true;
        }

        mostrarMensaje("Informacion de login invalida", "Informacion de login invalida", notificacionS,
                Alert.AlertType.WARNING);

        return false;
    }

    @FXML
    void crearCuenta(ActionEvent event) throws Exception {

        banco.mostrarVentana(Utils.Crear);
    }

}
