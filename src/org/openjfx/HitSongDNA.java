package org.openjfx;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.GaugeBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HitSongDNA extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        Button okButton = new Button("Ok");
        okButton.setDefaultButton(true);

        Button cancelButton = new Button("Cancel");

        Button icon = new Button("ICON HERE");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-color: deeppink");
        hBox.getChildren().addAll(okButton, cancelButton, icon);

        BorderPane root = new BorderPane();
        root.setTop(hBox);

        Image image = new Image(getClass().getResource("Resources/1.jpg").toURI().toString());
        ImageView imageView = new ImageView(image);


        System.out.println(System.getProperty("user.dir"));

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);

        chart.setTitle("Imported Fruits");
        //root.setCenter(chart);

        Gauge gauge2 = GaugeBuilder.create()
                .skinType(Gauge.SkinType.AMP)

                .titleColor(Color.WHITE)
                .ledVisible(true)
                .backgroundPaint(Color.WHITE)
                .foregroundPaint(Color.BLACK)
                .lcdVisible(true)
                .shadowsEnabled(true)
                .animated(true)
                .animationDuration(500)
                .title("Title")                                                                  // Text for title
                .titleColor(Color.WHITE)
                .ledVisible(true)                                                               // Should LED be visible
                .ledType(Gauge.LedType.STANDARD)                                                       // Type of the LED (STANDARD, FLAT)
                .ledColor(Color.rgb(99, 200, 0))                                                // Color of LED
                .ledBlinking(true)                                                              // Should LED blink
                .ledOn(true)   // Color for title text
                .unit("unit")                                                                    // Text for unit
                .unitColor(Color.BLACK)
                .build();


        root.setCenter(gauge2);


        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: #ddeeff; -fx-padding: 10px");

        vBox.getChildren().addAll(new Label("Select Color:"), new ColorPicker());
        root.setLeft(vBox);

        root.setStyle("-fx-background-color: #6680e6");

        Scene scene = new Scene(root, 740, 800);
        primaryStage.setTitle("Now we're talking");
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
