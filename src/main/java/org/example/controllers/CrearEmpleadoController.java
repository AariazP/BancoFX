package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.model.Empleado;
import org.example.services.DBConnection;

public class CrearEmpleadoController extends Controller {

    @FXML
    private TextField txtApellido;

    @FXML
    private PasswordField txtContra;

    @FXML
    private TextField txtDirec;

    @FXML
    private TextField txtEmail;

    @FXML
    private DatePicker txtFecha;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNomb;

    @FXML
    private TextField txtSaldo;

    @FXML
    private TextField txtTel;

    private String apellido;
    private String contrasenia;
    private String direccion;
    private String email;
    private String fecha;
    private String id;
    private String nombre;
    private String saldo;
    private String telefono;



    @FXML
    void crearCuenta(ActionEvent event) {

        Empleado empleado = new Empleado();
        empleado.setApellido(apellido);
        empleado.setContrasenia(contrasenia);
        empleado.setDireccion(direccion);
        empleado.setCorreo(email);
        empleado.setFechaNacimiento(fecha);
        empleado.setCedula(id);
        empleado.setNombre(nombre);

        banco.crearEmpleado(empleado);
        main.mostrarMensaje("Exito", "Exito", "Empleado creado con exito", Alert.AlertType.INFORMATION);
        DBConnection.getInstance().insertarEmpleado(empleado);

    }

    private void cargarDatos(){

        if(txtApellido.getText().isEmpty() || txtContra.getText().isEmpty()
                || txtDirec.getText().isEmpty() || txtEmail.getText().isEmpty()
                || txtFecha.getValue().toString().isEmpty() || txtId.getText().isEmpty()
                || txtNomb.getText().isEmpty() || txtSaldo.getText().isEmpty()
                || txtTel.getText().isEmpty()) {

            main.mostrarMensaje("Error", "Error", "Debe llenar todos los campos", Alert.AlertType.ERROR);

        }else{

            apellido = txtApellido.getText();
            contrasenia = txtContra.getText();
            direccion = txtDirec.getText();
            email = txtEmail.getText();
            fecha = txtFecha.getValue().toString();
            id = txtId.getText();
            nombre = txtNomb.getText();
            saldo = txtSaldo.getText();
            telefono = txtTel.getText();

        }


    }


}