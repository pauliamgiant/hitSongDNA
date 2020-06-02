package org.openjfx;

import classifier.Classifier;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URISyntaxException;


public class Controller {


    @FXML
    private ImageView imView;

    @FXML
    private Gauge gauge1;


    @FXML
    private Button catchMe;

    @FXML
    public void initialize() throws URISyntaxException {
       Image image = new Image(getClass().getResource("Resources/1.jpg").toURI().toString());

        gauge1 = GaugeBuilder.create()
                .skinType(Gauge.SkinType.AMP)
                .titleColor(Color.WHITE)
                .ledVisible(true)
                .backgroundPaint(Color.WHITE)
                .foregroundPaint(Color.BLACK)
                .lcdVisible(true)
                .shadowsEnabled(true)
                .animated(true)
                .animationDuration(500)
                .title("title")                                                                  // Text for title
                .titleColor(Color.WHITE)
                .ledVisible(true)                                                               // Should LED be visible
                .ledType(Gauge.LedType.STANDARD)                                                       // Type of the LED (STANDARD, FLAT)
                .ledColor(Color.rgb(99, 200, 0))                                                // Color of LED
                .ledBlinking(true)                                                              // Should LED blink
                .ledOn(true)   // Color for title text
                .unit("unit")                                                                    // Text for unit
                .unitColor(Color.BLACK)
                .build();

        Classifier paulsCl = new Classifier();
        catchMe.setText(paulsCl.testing());
        System.out.println(paulsCl.testing());
       imView.setImage(image);
    }




}
