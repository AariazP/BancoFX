package org.example.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import lombok.Getter;
import lombok.Setter;
import org.example.application.Main;
import org.example.model.Banco;

@Getter
@Setter
public abstract class Controller {

    public Main main;
    Banco banco = Banco.getInstance();

    public void mostrarMensaje(String titulo, String header, String mensaje, AlertType alerta) {

        Alert alert = new Alert(alerta);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}
