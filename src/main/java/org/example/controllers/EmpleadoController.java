package org.example.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.model.Empleado;
import org.example.utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadoController extends Controller implements Initializable {

    Empleado pasivo = (Empleado) main.getPersonaPasiva();
    @FXML
    private Label LabelId;

    @FXML
    private Label labelApd;

    @FXML
    private Label labelDirec;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelNomb;

    @FXML
    private Label labelTel;

    @FXML
    void salir(MouseEvent event) throws Exception {

        main.loadStage(Utils.Cliente);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        labelApd.setText(pasivo.getApellido());
        labelDirec.setText(pasivo.getDireccion());
        labelEmail.setText(pasivo.getCorreo());
        labelNomb.setText(pasivo.getNombre());
        labelTel.setText(pasivo.getTelefono());
        LabelId.setText(pasivo.getCedula());
    }
}