package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.model.Cliente;
import org.example.model.Empleado;
import org.example.utils.Utils;

public class AdminController extends Controller{

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

    //creo un observable list para los clientes y empleados
    private ObservableList<Cliente> observableClientes = FXCollections.observableArrayList();
    private ObservableList<Empleado> observableEmpleados = FXCollections.observableArrayList();


    @FXML
    void actualizarCliente(ActionEvent event) {
        Cliente cliente = tableClientes.getSelectionModel().getSelectedItem();
        banco.actualizarCliente(cliente);
        main.mostrarMensaje("Exito", "Exito", "El cliente se actualizó correctamente", Alert.AlertType.INFORMATION);

    }

    @FXML
    void actualizarEmp(ActionEvent event) {
        Empleado empleado = tableEmpleados.getSelectionModel().getSelectedItem();
        banco.actualizarEmpleado(empleado);
    }

    @FXML
    void crearCliente(ActionEvent ignoredEvent) throws Exception {
        main.loadStage(Utils.Crear);
    }
    @FXML
    void crearEmp(ActionEvent event) throws Exception {
        main.loadStage(Utils.CrearEmpleado);
    }

    @FXML
    void eliminarCliente(ActionEvent event) {

        Cliente cliente = tableClientes.getSelectionModel().getSelectedItem();
        banco.eliminarCliente(cliente);

    }

    @FXML
    void eliminarEmp(ActionEvent event) {
        Empleado empleado = tableEmpleados.getSelectionModel().getSelectedItem();
        banco.eliminarEmpleado(empleado);
    }

    @FXML
    void salir(MouseEvent event) throws Exception {
        main.loadStage(Utils.Login);
    }

    @FXML
    void initialize(){
        observableClientes.addAll(banco.getListaClientes());
        observableEmpleados.addAll(banco.getListaEmpleados());

        tableColumCliApd.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableColumCliEmail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tableColumCliId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        tableColumCliNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumCliSaldo.setCellValueFactory(new PropertyValueFactory<>(""));
        tableClientes.setItems(observableClientes);

        tableEmpColumApd.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableEmpColumCod.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        tableEmpColumEmail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tableEmpColumId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        tableEmpColumNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableEmpColumSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tableEmpleados.setItems(observableEmpleados);

        tableClientes.refresh();
        tableEmpleados.refresh();

    }
}
