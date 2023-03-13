package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.model.Cliente;
import org.example.model.Empleado;
import org.example.utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadosController extends Controller implements Initializable {
    private ObservableList<Empleado> observableEmpleados = FXCollections.observableArrayList();
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
    void asociarEmp(ActionEvent event) {

        Empleado empleado = tableEmpleados.getSelectionModel().getSelectedItem();
        Cliente cliente = (Cliente) main.getPersonaPasiva();
        banco.asociaciarEmpleado(empleado, cliente);
        main.mostrarMensaje("Information", "Information", "El empleado ha sido asociado", Alert.AlertType.INFORMATION);
    }

    @FXML
    void salir(MouseEvent event) throws Exception {

        main.loadStage(Utils.Admin);
    }

    public void llenarTablas(){

        tableEmpleados.getItems().clear();

        observableEmpleados.addAll(banco.getListaEmpleados());

        tableEmpColumApd.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableEmpColumCod.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        tableEmpColumEmail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tableEmpColumId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        tableEmpColumNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableEmpColumSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tableEmpleados.setItems(observableEmpleados);

        tableEmpleados.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        llenarTablas();
    }
}
