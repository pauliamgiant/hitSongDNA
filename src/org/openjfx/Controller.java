package org.openjfx;

import classifier.*;
import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.model.structure.StringField;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.chart.ChartData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private Classifier classifier;
    private DataSet oneHitWonders;
    private Boolean hitOrNot;
    private DataTuple newHitTuple;
    private DataTuple newMissTuple;

    @FXML
    private Form songAttributes;

    @FXML
    private Form chordAttributes;


    @FXML
    private Form toplineAttributes;

    @FXML
    private Form lyricAttributes;


    @FXML
    private ImageView imView;

    @FXML
    private FontAwesomeIconView iconView;

    @FXML
    private FontAwesomeIconView classifyIcon;


    @FXML
    public void showPopup(ActionEvent event) {
        showStage();
    }

    @FXML
    public void popup2(ActionEvent event) {
        Alert pu2 = new Alert(Alert.AlertType.ERROR);
        pu2.setContentText("Stop fool!");
        pu2.setHeaderText("Arrrrrggghhhhhh");
        pu2.setTitle("IMBECILE!!!");
        pu2.show();
    }

    @FXML
    private Label hitLabel;

    @FXML
    private Tile ledTile;

    @FXML
    private Button okButton;

    @FXML
    private Button classifyButton;

    @FXML
    private Button popMe;

    @FXML
    private Gauge gauge1;

    @FXML
    private Gauge gauge3;

    @FXML
    private VBox forForm;

    @FXML
    private Button catchMe;

    @FXML
    private VBox myPie;

    @FXML
    private VBox songMetrics;

    @FXML
    public Button getPopMe() {
        return popMe;
    }


    @FXML
    public void initialize() throws URISyntaxException {
        try {
            oneHitWonders = new DataSet();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        newHitTuple = TupleBuilder.getUnclassifiedHitTuple();
        newMissTuple = TupleBuilder.getUnclassifiedMissTuple();
        classifier = new NaiveBayes(oneHitWonders);


        classifyIcon.setIcon(FontAwesomeIcon.PIED_PIPER_PP);
        classifyIcon.setSize("2em");
        classifyIcon.setFill(Color.LIGHTGRAY);
        classifyButton.setGraphic(classifyIcon);

        iconView.setIcon(FontAwesomeIcon.AMBULANCE);
        iconView.setSize("2em");
        iconView.setFill(Color.CYAN);
        popMe.setGraphic(iconView);

// here is where the logo goes
//        Image image = new Image(getClass().getResource("Resources/1.png").toURI().toString());
//        imView.setImage(image);

        Alert a = new Alert(Alert.AlertType.NONE);

        // action event
        EventHandler<ActionEvent> event = e -> {
            a.setAlertType(Alert.AlertType.CONFIRMATION);
            a.show();
        };
        popMe.setOnAction(event);

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


        songAttributes = Form.of(
                Group.of(


                        Field.ofStringType("")
                                .label("Song Title")
                                .required("")
                                .tooltip("The title of your song.")
                        .placeholder("Please enter the title of your song here."),
                        Field.ofSingleSelectionType(tempos)
                                .label("Intro Length")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Tempo")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Genre")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .placeholder("Please select type of Voice(s from the below)")
                                .label("Lead Singer(s)")
                                .required("This field can’t be empty")
                               ,

                        Field.ofSingleSelectionType(tempos)
                                .label("Basic Drum Pattern")
                                .required("This field can’t be empty"),
                        Field.ofBooleanType(false)
                                .label("Co-writer with Top 40 history")
                )
        );




        chordAttributes = Form.of(
                Group.of(Field.ofSingleSelectionType(tempos)
                                .label("Key of Verse")
                                .required("This field can’t be empty"),
                        Field.ofBooleanType(false)
                                .label("Verse Starts on Chord I"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Verse Ionian")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Vs Chordcount")
                                .required("This field can’t be empty"),
                        Field.ofBooleanType(false)
                                .label("Vs/Ch same chords"),
                        Field.ofBooleanType(false)
                                .label("Vs has Key Change"),
                        Field.ofBooleanType(false)
                                .label("Chorus Starts on Chord I"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Ch Chordcount")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Total chords used")
                                .required("This field can’t be empty"))


        );


        toplineAttributes = Form.of(
                Group.of(
                        Field.ofSingleSelectionType(tempos)
                                .label("Vs Topline start note")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Vs No. notes in Topline")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Vs Topline Type")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Ch Topline start note")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Ch No. notes in Topline")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Ch Topline Type")
                                .required("This field can’t be empty")

                )

        );


        lyricAttributes = Form.of(
                Group.of(
                        Field.ofStringType("")
                                .multiline(true)
                                .required("This field can’t be empty")
                        .label("Paste Lyrics"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Rhymecount")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(tempos)
                                .label("Lyrical Archetype")
                                .required("This field can’t be empty")

                )

        );


        forForm.getChildren().add(new Label("Song Attributes"));
        forForm.getChildren().add(new FormRenderer(songAttributes));
        forForm.getChildren().add(new Label("Chord Information"));
        forForm.getChildren().add(new FormRenderer(chordAttributes));
        forForm.getChildren().add(new Label("Topline Information"));
        forForm.getChildren().add(new FormRenderer(toplineAttributes));
        forForm.getChildren().add(new Label("Lyrical Information"));
        forForm.getChildren().add(new FormRenderer(lyricAttributes));


        //NaiveBayes paulsCl = new NaiveBayes();
        catchMe.setText("Classifier go here");
        // System.out.println(paulsCl.testing());

//        ObservableList<PieChart.Data> myPieG = FXCollections.observableArrayList(
//                new PieChart.Data("I-IV-V", 13),
//                new PieChart.Data("i-VII-VI-VII", 25),
//                new PieChart.Data("VI-VII-i-i", 10),
//                new PieChart.Data("I-V-vi-IV", 22),
//                new PieChart.Data("i-i-iv-iv", 30));
//        final PieChart chart = new PieChart(myPieG);
//
//        chart.setPrefSize(400, 400);

        ChartData chartData1 = new ChartData("I-IV-V", 24.0, Tile.DARK_BLUE);
        ChartData chartData2 = new ChartData("i-VII-VI-VII", 10.0, Tile.BLUE);
        ChartData chartData3 = new ChartData("VI-VII-i-i", 12.0, Tile.GRAY);
        ChartData chartData4 = new ChartData("I-V-vi-IV", 13.0, Tile.GREEN);
        ChartData chartData5 = new ChartData("Item 5", 13.0, Tile.BLUE);
        ChartData chartData6 = new ChartData("Item 6", 13.0, Tile.BLUE);
        ChartData chartData7 = new ChartData("Item 7", 13.0, Tile.BLUE);
        ChartData chartData8 = new ChartData("Item 8", 13.0, Tile.BLUE);

        Tile donutChartTile = TileBuilder.create()
                .skinType(Tile.SkinType.DONUT_CHART)
                .prefSize(800, 800)
                .title("Most Common Chords")
                .text("")
                .textVisible(false)
                .chartData(chartData1, chartData2, chartData3, chartData4)
                .build();

        myPie.getChildren().add(donutChartTile);

//        chart.setTitle("Chord Progressions");
//        chart.setLabelLineLength(10);
//        chart.setLegendSide(Side.LEFT);

        //chart.setAnimated(true);

        gauge1.setValue(0);
        gauge1.setForegroundBaseColor(Color.AQUA);
        gauge1.setTitleColor(Color.WHITE);
        gauge1.setBarColor(Color.AQUA);
        gauge3.setValue(0);


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

    @FXML
    public void loadHit() {
        System.out.println("HIT");
        hitOrNot = classifier.songIsLikelyToBeAHit(newHitTuple);
    }

    @FXML
    public void loadMiss() {
        System.out.println("MISS");
        hitOrNot = classifier.songIsLikelyToBeAHit(newMissTuple);
    }

    @FXML
    public void executeClassification() {

        //System.out.println(songAttributes.getElements());

        List info = songAttributes.getElements();
        String[] tupleData = new String[29];
        StringField sf1 = (StringField) info.get(0);
        tupleData[0] = sf1.getValue();
        System.out.println(songAttributes.isValid());


        try {
            if (hitOrNot) {
                gauge1.setValue(65);
                gauge1.setForegroundBaseColor(Color.AQUA);
                gauge1.setTitleColor(Color.WHITE);
                gauge1.setBarColor(Color.AQUA);
                gauge3.setVisible(true);
                gauge3.setValue(63);
                hitLabel.setStyle("-fx-text-fill: cyan;");
                ledTile.setActive(true);
                ledTile.setActiveColor(Color.CYAN);
                hitLabel.setText("HIT!!");
            }
            if (!hitOrNot) {
                gauge1.setValue(35);
                gauge1.setForegroundBaseColor(Color.DARKRED);
                gauge1.setBarColor(Color.DARKRED);
                gauge1.setValueColor(Color.RED);
                gauge3.setVisible(false);
                ledTile.setActive(true);
                ledTile.setActiveColor(Color.RED);
                hitLabel.setStyle("-fx-text-fill: red;");
                hitLabel.setText("MISS");
            }
        } catch (Exception exception) {
//            Alert pu2 = new Alert(Alert.AlertType.ERROR);
//            pu2.setContentText("You will need a complete form to continue");
//            pu2.setHeaderText("Incomplete Song Data");
//            pu2.setTitle("Error!");
//            pu2.show();
        }
    }


    public static void showPopup2(Window win) {
        Popup popup = new Popup();
        popup.setX(300);
        popup.setY(200);
        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
        popup.show(win);
    }


}
