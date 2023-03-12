package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class crearCuentaController extends Controller implements Initializable {


    ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> boxCuenta;

    @FXML
    private DatePicker txtFecha;

    @FXML
    private TextField txtApellido;

    @FXML
    private Button btnCrear;

    @FXML
    private PasswordField txtContra;

    @FXML
    private TextField txtDirec;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNomb;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtSaldo;

    @FXML
    private TextField txtNumCuenta;

    @FXML
    void devolverLogin(MouseEvent event) throws Exception {

        banco.mostrarVentana(Utils.Login);
    }

    @FXML
    void crearCuenta(ActionEvent event) throws Exception {

        String nomb = txtNomb.getText();
        String apd = txtApellido.getText();
        String email = txtEmail.getText();
        String id = txtId.getText();
        String direc = txtDirec.getText();
        String contra = txtContra.getText();
        String numC = txtNumCuenta.getText();
        String tel = txtTel.getText();
        String fecha = txtFecha.toString();
        String tipo = boxCuenta.toString();
        Double saldo;
        try{

            saldo = Double.parseDouble(txtSaldo.getText());
        }catch (NumberFormatException e){

            saldo = -1.0;
        }

        if(datosValidos(nomb, apd, tel, email, id, direc, contra, numC, fecha, saldo, tipo)){

            banco.crearhCliente(nomb, id, apd, direc, tel, email, fecha, contra, saldo, tipo, numC);
            mostrarMensaje("Registro exitoso", "Registro exitos", "Enhorabuena ya fue creada su cuenta",
                    Alert.AlertType.CONFIRMATION);
            banco.mostrarVentana(Utils.Login);
        }
    }

    private boolean datosValidos(String nomb, String apd, String tel, String email, String id, String direc, String contra, String numC, String fecha, Double saldo, String tipo) {

        String notificacionS = "";

        if (nomb == null || nomb.equals("")) {

            notificacionS += "Debe ingresar un nombre.\n";
        }

        if (apd == null || apd.equals("")) {

            notificacionS += "Debe ingresar un apellido.\n";
        }

        if (tel == null || tel.equals("")) {

            notificacionS += "Debe ingresar un nombre.\n";
        }

        if (email == null || email.equals("")) {

            notificacionS += "Debe ingresar un email.\n";
        }

        if (id == null || id.equals("")) {

            notificacionS += "Debe ingresar un id.\n";
        }

        if (direc == null || direc.equals("")) {

            notificacionS += "Debe ingresar una dirección.\n";
        }

        if (contra == null || contra.equals("")) {

            notificacionS += "Debe ingresar una contraseña.\n";
        }

        if (numC == null || numC.equals("")) {

            notificacionS += "Debe ingresar un numero de cuenta.\n";
        }

        if (fecha == null || fecha.equals("")) {

            notificacionS += "Debe ingresar una fecha de nacimiento.\n";
        }

        if (saldo < 0) {

            notificacionS += "Debe ingresar un saldo valido.\n";
        }

        if (tipo == null || tipo.equals("")) {

            notificacionS += "Debe ingresar un tipo de cuenta.\n";
        }

        if (notificacionS.equals("")) {
            return true;
        }

        mostrarMensaje("Informacion de registro invalida", "Informacion de registro invalida", notificacionS,
                Alert.AlertType.WARNING);

        return false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        items.addAll("Cuenta Corriente", "Cuenta Ahorros");
        boxCuenta.getItems().addAll(items);
    }
}
