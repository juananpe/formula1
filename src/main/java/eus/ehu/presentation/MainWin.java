package eus.ehu.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainWin extends Application {
    @Override
    public void start(Stage stage){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainLayout.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Formula 1 Dashboard");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error loading mainLayout.fxml");
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
