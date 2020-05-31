package org.openjfx;

import classifier.Classifier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URISyntaxException;


public class Controller {


    @FXML
    private ImageView imView;

    @FXML
    private Button catchMe;

    @FXML
    public void initialize() throws URISyntaxException {
       Image image = new Image(getClass().getResource("Resources/1.jpg").toURI().toString());
        Classifier paulsCl = new Classifier();
        catchMe.setText(paulsCl.testing());
        System.out.println(paulsCl.testing());
       imView.setImage(image);
    }


}
