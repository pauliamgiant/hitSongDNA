package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;


public class HitSongDNA extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("UI.fxml"));
        Controller controller = (Controller) loader.getController();





        Scene scene = new Scene(root, 1280, 768);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("HitSongDNA");
        primaryStage.setScene(scene);

        primaryStage.show();
        //showPopup(primaryStage);





    }


    public static void main(String[] args) {
        launch(args);
    }


    public void showPopup(Window primaryStage) {

        Popup popup = new Popup();
        popup.setX(300); popup.setY(200);
        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
        popup.show(primaryStage);
    }

    public boolean testTesting(){
        return true;
    }

}
