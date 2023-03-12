package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.model.Cliente;
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


    private String name;
    private String lastName;
    private String email;
    private String id;
    private String address;
    private String password;
    private String numCuenta;
    private String telefono;
    private String fecha;
    private String tipo;
    private Double saldo;


    @FXML
    void devolverLogin(MouseEvent ignoredEvent) throws Exception {
        main.loadStage(Utils.Login);
    }

    @FXML
    void crearCuenta(ActionEvent ignoredEvent) throws Exception {

        loadTextFields();

        if (datosValidos()) {
            Cliente cliente = new Cliente(name, lastName, telefono, email, id, address, password, numCuenta, fecha, saldo, tipo);
            banco.crearCliente(cliente);
            main.mostrarMensaje("Registro exitoso", "Registro exitoso", "Enhorabuena ya fue creada su cuenta",
                    Alert.AlertType.CONFIRMATION);
            main.loadStage(Utils.Login);
        }
    }

    private void loadTextFields() {

        name = txtNomb.getText();
        lastName = txtApellido.getText();
        email = txtEmail.getText();
        id = txtId.getText();
        address = txtDirec.getText();
        password = txtContra.getText();
        numCuenta = txtNumCuenta.getText();
        telefono = txtTel.getText();
        fecha = txtFecha.toString();
        tipo = boxCuenta.toString();
        try {
            saldo = Double.parseDouble(txtSaldo.getText());
        } catch (NumberFormatException e) {
            saldo = -1.0;
        }
    }

    private boolean datosValidos() {

        String notificacion = "";

        if (name == null || name.equals("")) notificacion += "Debe ingresar un nombre.\n";
        if (lastName == null || lastName.equals("")) notificacion += "Debe ingresar un apellido.\n";
        if (telefono == null || telefono.equals("")) notificacion += "Debe ingresar un nombre.\n";
        if (email == null || email.equals("")) notificacion += "Debe ingresar un email.\n";
        if (id == null || id.equals("")) notificacion += "Debe ingresar un id.\n";
        if (address == null || address.equals("")) notificacion += "Debe ingresar una dirección.\n";
        if (password == null || password.equals("")) notificacion += "Debe ingresar una contraseña.\n";
        if (numCuenta == null || numCuenta.equals("")) notificacion += "Debe ingresar un numero de cuenta.\n";
        if (fecha == null || fecha.equals("")) notificacion += "Debe ingresar una fecha de nacimiento.\n";
        if (saldo < 0) notificacion += "Debe ingresar un saldo valido.\n";
        if (tipo == null || tipo.equals("")) notificacion += "Debe ingresar un tipo de cuenta.\n";
        if (notificacion.equals("")) return true;

        main.mostrarMensaje("Informacion de registro invalida", "Informacion de registro invalida", notificacion,
                Alert.AlertType.WARNING);

        return false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        items.addAll("Cuenta Corriente", "Cuenta Ahorros");
        boxCuenta.getItems().addAll(items);
    }
}
