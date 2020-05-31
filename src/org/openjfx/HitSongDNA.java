package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HitSongDNA extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        root.setStyle("-fx-background-color: darkblue");
        Scene scene = new Scene(root, 1024, 720);

        primaryStage.setTitle("JavaFX!!!! with FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public boolean testTesting() {

        return true;
    }
}
