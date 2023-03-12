package org.example.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.example.model.Cliente;
import org.example.model.Empleado;

public class AdminController {

    @FXML
    private Button btnActCli;

    @FXML
    private Button btnActEmp;

    @FXML
    private Button btnCrearCli;

    @FXML
    private Button btnCrearEmp;

    @FXML
    private Button btnElimCli;

    @FXML
    private Button btnElimEmp;

    @FXML
    private TableView<Cliente> tableClientes;

    @FXML
    private TableColumn<Cliente, String> tableColumCliApd;

    @FXML
    private TableColumn<Cliente, String> tableColumCliEmail;

    @FXML
    private TableColumn<Cliente, String> tableColumCliId;

    @FXML
    private TableColumn<Cliente, String> tableColumCliNom;

    @FXML
    private TableColumn<Cliente, Double> tableColumCliSaldo;

    @FXML
    private TableColumn<Empleado, String> tableEmpColumApd;

    @FXML
    private TableColumn<Empleado, String> tableEmpColumCod;

    @FXML
    private TableColumn<Empleado, String> tableEmpColumEmail;

    @FXML
    private TableColumn<Empleado, String> tableEmpColumId;

    @FXML
    private TableColumn<Empleado, String> tableEmpColumNom;

    @FXML
    private TableColumn<Empleado, String> tableEmpColumSalario;

    @FXML
    private TableView<Empleado> tableEmpleados;

    @FXML
    void actualizarCliente(ActionEvent event) {

    }

    @FXML
    void actualizarEmp(ActionEvent event) {

    }

    @FXML
    void crearCliente(ActionEvent event) {

    }

    @FXML
    void crearEmp(ActionEvent event) {

    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    }

    @FXML
    void eliminarEmp(ActionEvent event) {

    }

    @FXML
    void salir(MouseEvent event) {

    }
}
