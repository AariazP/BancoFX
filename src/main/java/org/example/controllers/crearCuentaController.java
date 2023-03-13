package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import org.example.model.*;
import org.example.services.DBConnection;
import org.example.utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class crearCuentaController extends Controller implements Initializable {


    ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> boxTipo;

    @FXML
    private CheckBox checkBoxEmp;

    @FXML
    private Label labelNum;

    @FXML
    private Label labelSal;

    @FXML
    private Label labelTipo;

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

        if(isLogin){

            main.loadStage(Utils.Login);
        }else{

            main.loadStage(Utils.Admin);
        }
    }

    @FXML
    void crearCuenta(ActionEvent ignoredEvent) throws Exception {

        loadTextFields();

        if (datosValidos()) {
            if(checkBoxEmp.isSelected()){

                Empleado empleado = new Empleado(name, lastName, id, address, telefono, email, fecha, password, saldo);

                if(tipo == "Gerente"){

                    empleado = new Gerente(name, lastName, id, address, telefono, email, fecha, password, saldo);
                } else if (tipo == "Cajero") {

                    empleado = new Cajero(name, lastName, id, address, telefono, email, fecha, password, saldo);
                }else{

                    empleado = new AsesorVentas(name, lastName, id, address, telefono, email, fecha, password, saldo);
                }
                banco.crearEmpleado(empleado);
                DBConnection.getInstance().insertarEmpleado(empleado);
            }else{

                Cliente cliente = new Cliente(name, lastName, telefono, email, id, address, password, numCuenta, fecha, saldo, tipo);
                banco.crearCliente(cliente);
                DBConnection.getInstance().agregarCliente(cliente);
            }

            main.mostrarMensaje("Registro exitoso", "Registro exitoso", "Enhorabuena ya fue creada su cuenta",
                    Alert.AlertType.CONFIRMATION);
            if(isLogin){

                main.loadStage(Utils.Login);
            }else{

                main.loadStage(Utils.Admin);
            }
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
        fecha = txtFecha.getValue().toString();
        tipo = boxTipo.toString();
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
        if(!checkBoxEmp.isSelected()){
            if (numCuenta == null || numCuenta.equals("")) notificacion += "Debe ingresar un numero de cuenta.\n";
        }
        if (fecha == null || fecha.equals("")) notificacion += "Debe ingresar una fecha de nacimiento.\n";
        if (saldo < 0) notificacion += "Debe ingresar un saldo valido.\n";
        if (tipo == null || tipo.equals("")) notificacion += "Debe ingresar un tipo de cuenta.\n";
        if (notificacion.equals("")) return true;

        main.mostrarMensaje("Informacion de registro invalida", "Informacion de registro invalida", notificacion,
                Alert.AlertType.WARNING);

        return false;
    }

    @FXML
    void modificarVista(MouseEvent event) {

        if(checkBoxEmp.isSelected()){

            labelTipo.setText("Type");
            labelNum.setText("");
            labelSal.setText("Salary");
            txtNumCuenta.setBackground(Background.EMPTY);
            txtNumCuenta.setDisable(true);
            items.removeAll("Cuenta Corriente", "Cuenta Ahorros");
            items.addAll("Gerente", "AsesorVentas", "Cajero");
            boxTipo.getItems().removeAll("Cuenta Corriente", "Cuenta Ahorros");
            boxTipo.getItems().addAll(items);
        }else{

            labelTipo.setText("Bank Account");
            labelNum.setText("Account number");
            labelSal.setText("Initial Balance");
            txtNumCuenta.setBackground(Background.fill(Color.WHITE));
            txtNumCuenta.setDisable(false);
            items.removeAll("Gerente", "AsesorVentas", "Cajero");
            items.addAll("Cuenta Corriente", "Cuenta Ahorros");
            boxTipo.getItems().removeAll("Gerente", "AsesorVentas", "Cajero");
            boxTipo.getItems().addAll(items);
        }

    }

    public void actualizarDatos(){

        if(isUpdate){
            if(isEmp){

                Empleado empleado = (Empleado) main.getPersonaPasiva();
                checkBoxEmp.setSelected(true);
                txtApellido.setText(empleado.getApellido());
                txtContra.setText(empleado.getContrasenia());
                txtDirec.setText(empleado.getDireccion());
                txtEmail.setText(empleado.getCorreo());
                txtNomb.setText(empleado.getNombre());
                txtId.setText(empleado.getCedula());
                txtSaldo.setText(empleado.getSalario() + "");
                txtTel.setText(empleado.getTelefono());
            }else{

                Cliente cliente = (Cliente) main.getPersonaPasiva();
                checkBoxEmp.setSelected(false);
                txtApellido.setText(cliente.getApellido());
                txtContra.setText(cliente.getContrasenia());
                txtDirec.setText(cliente.getDireccion());
                txtEmail.setText(cliente.getCorreo());
                txtNomb.setText(cliente.getNombre());
                txtId.setText(cliente.getCedula());
                txtSaldo.setText(cliente.getCuenta().getSaldo() + "");
                txtTel.setText(cliente.getTelefono());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //actualizarDatos();
        items.addAll("Cuenta Corriente", "Cuenta Ahorros");
        boxTipo.getItems().addAll(items);
    }
}
