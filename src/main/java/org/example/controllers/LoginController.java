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
import org.example.model.Persona;
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

    private String email;

    private String password;


    @FXML
    void login(ActionEvent ignoredEvent) throws Exception {

        cargarDatos();

        if(datosValidos()){

            Persona persona = banco.getPersona(email, password);

            if(persona == null){
                main.mostrarMensaje("Informacion de login invalida", "Informacion de login invalida", "El usuario que ingreso no esta registrado",
                        Alert.AlertType.WARNING);
                txtEmail.setText("");
                txtPassword.setText("");
                return;
            } else if (persona instanceof Cliente cliente) {
                main.setPersonaActiva(cliente);
                main.loadStage(Utils.Cliente);
            } else {
                main.setPersonaActiva(persona);
                main.loadStage(Utils.Admin);
            }
            
        }

    }

    private void cargarDatos() {
        email = txtEmail.getText();
        password = txtPassword.getText();
    }

    private boolean datosValidos(){

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            main.mostrarMensaje("Informacion de login invalida", "Informacion de login invalida",
                    "Debe ingresar un correo y una contraseña.", Alert.AlertType.WARNING);
            return false;
        }

        return true;
    }
    @FXML
    void crearCuenta(ActionEvent ignoredEvent) throws Exception {
        main.loadStage(Utils.Crear);
    }

}
