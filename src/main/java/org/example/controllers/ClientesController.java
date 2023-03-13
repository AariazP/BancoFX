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

public class ClientesController extends Controller implements Initializable {
    private ObservableList<Cliente> observableCliente = FXCollections.observableArrayList();
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
    void asociarCli(ActionEvent event) {

        Cliente cliente = tableClientes.getSelectionModel().getSelectedItem();
        Empleado empleado = (Empleado) main.getPersonaPasiva();
        banco.asociaciarCliente(cliente, empleado);
        main.mostrarMensaje("Information", "Information", "El cliente ha sido asociado", Alert.AlertType.INFORMATION);
    }

    @FXML
    void salir(MouseEvent event) throws Exception {

        main.loadStage(Utils.Admin);
    }

    public void llenarTablas(){

        tableClientes.getItems().clear();

        observableCliente.addAll(banco.getListaClientes());

        tableColumCliApd.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableColumCliId.setCellValueFactory(new PropertyValueFactory<>("identificador"));
        tableColumCliEmail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tableColumCliNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableClientes.setItems(observableCliente);

        tableClientes.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        llenarTablas();
    }
}
