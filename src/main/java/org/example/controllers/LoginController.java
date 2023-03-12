package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Banco;
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
    private PasswordField txtPassword;

    @FXML
    void login(ActionEvent event) throws Exception {

        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(datosValidos(email, password)){

            Cliente cli = Banco.getInstance().loginCliente(email, password);
            if(cli != null){

                main.setPersonaActiva(cli);
                main.loadStage(Utils.Cliente);
            }else{

                main.mostrarMensaje("Informacion de login invalida", "Informacion de login invalida", "El usuario que ingreso no esta registrado",
                        Alert.AlertType.WARNING);
                txtEmail.setText("");
                txtPassword.setText("");
            }
        }
    }

    private boolean datosValidos(String email, String paswd) {

        String notificacion = "";

        if (email == null || email.equals("")) {

            notificacion += "Debe ingresar un correo.\n";
        }

        if (paswd == null || paswd.equals("")) {

            notificacion += "Debe ingresar una contraseña.\n";
        }
        if (notificacion.equals("")) {
            return true;
        }

        main.mostrarMensaje("Informacion de login invalida", "Informacion de login invalida", notificacion,
                Alert.AlertType.WARNING);

        return false;
    }

    @FXML
    void crearCuenta(ActionEvent event) throws Exception {

        main.loadStage(Utils.Crear);
    }

}
