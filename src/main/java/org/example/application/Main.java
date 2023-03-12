package org.example.application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.controllers.Controller;
import org.example.model.Persona;
import org.example.utils.Utils;

import java.util.Objects;

public class Main extends Application{

    private Stage stage;
    private Persona personaActiva;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Utils.Login));
        Pane root = loader.load();
        /*Controller controller = loader.getController();
        controller.setMain(this);*/
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loadStage(String ruta) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
        Pane root = loader.load();
        Controller controller = loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(root);
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }

}