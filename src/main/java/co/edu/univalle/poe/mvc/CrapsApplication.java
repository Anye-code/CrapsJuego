//carga la ventana
package co.edu.univalle.poe.mvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CrapsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException { //stage=ventana
        FXMLLoader fxmlLoader = new FXMLLoader(CrapsApplication.class.getResource("view/craps-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240); //escena ventana
        stage.setTitle("Juego Craps");
        stage.setScene(scene);
        stage.show();
    }
}

