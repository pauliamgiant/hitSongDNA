package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HitSongDNA extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {



        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("UI.fxml"));
        //Controller controller = (Controller) loader.getController();
        Scene scene = new Scene(root, 1280, 768);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("HitSongDNA");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void LoadingPopup() {
        Stage newStage = new Stage();
        VBox comp = new VBox();
        TextField nameField = new TextField("Name");
        TextField phoneNumber = new TextField("Phone Number");
        comp.getChildren().add(nameField);
        comp.getChildren().add(phoneNumber);

        Scene stageScene = new Scene(comp, 300, 300);
        newStage.setScene(stageScene);
        newStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    public boolean testTesting(){
        return true;
    }

}
