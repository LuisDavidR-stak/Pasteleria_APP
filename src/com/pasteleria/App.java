package com.pasteleria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/DashboardView.fxml"));
        Scene scene = new Scene(loader.load());

        stage.setTitle("Gestión de Pastelería - Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}
