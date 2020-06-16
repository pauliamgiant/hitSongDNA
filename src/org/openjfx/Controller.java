package org.openjfx;

import classifier.Classifier;
import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import eu.hansolo.medusa.Gauge;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Controller {


    @FXML
    private ImageView imView;

    @FXML
    public void showPopup(ActionEvent event) {
        showStage();
    }

    @FXML
    private Button okButton;

    @FXML
    private Button popMe;

    @FXML
    private Gauge gauge1;

    @FXML
    private VBox forForm;

    @FXML
    private Button catchMe;

    @FXML
    private VBox myPie;

    @FXML
    private VBox songMetrics;

    @FXML
    public Button getPopMe(){
        return popMe;
    }

    @FXML
    public void initialize() throws URISyntaxException {
        // Image image = new Image(getClass().getResource("Resources/1.jpg").toURI().toString());

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                showStage();
            }
        });


        List<String> tempos = new ArrayList<>();
        tempos.add("below 80");
        tempos.add("80-100");
        tempos.add("100-110");
        tempos.add("110-120");
        tempos.add("120-130");
        tempos.add("above 130");

        Form loginForm = Form.of(
                Group.of(
                        Field.ofStringType("")
                                .label("Song Title")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Tempo Range")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Chord Progression")
                                .required("This field can’t be empty"),

                        Field.ofSingleSelectionType(tempos)
                                .label("Topline Harmony")
                                .required("This field can’t be empty"),

                        Field.ofSingleSelectionType(tempos)
                                .label("Tempo Range")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Key")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Mode")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Lyrical Repetition")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Hook in Song Title")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Time Signature")
                                .required("This field can’t be empty"),
                        Field.ofBooleanType(false)
                                .label("Female Artist"),
                        Field.ofBooleanType(false)
                                .label("Male Artist")
                )


        ).title("Song Attributes");


        forForm.getChildren().add(new FormRenderer(loginForm));


        Classifier paulsCl = new Classifier();
        catchMe.setText(paulsCl.testing());
        System.out.println(paulsCl.testing());
        //imView.setImage(image);
        ObservableList<PieChart.Data> myPieG = FXCollections.observableArrayList(
                new PieChart.Data("I-IV-V", 13),
                new PieChart.Data("i-VII-VI-VII", 25),
                new PieChart.Data("VI-VII-i-i", 10),
                new PieChart.Data("I-V-vi-IV", 22),
                new PieChart.Data("i-i-iv-iv", 30));
        final PieChart chart = new PieChart(myPieG);

        chart.setPrefSize(400, 400);


        myPie.getChildren().add(chart);

        chart.setTitle("Chord Progressions");
        chart.setLabelLineLength(10);
        chart.setLegendSide(Side.LEFT);

        //chart.setAnimated(true);

        gauge1.setValue(89);
        gauge1.setForegroundBaseColor(Color.AQUA);
        gauge1.setTitleColor(Color.WHITE);
        gauge1.setBarColor(Color.AQUA);


    }

    @FXML
    public static void showStage() {
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

    public static void showPopup2(Window win) {
        Popup popup = new Popup();
        popup.setX(300); popup.setY(200);
        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
        popup.show(win);
}



}
