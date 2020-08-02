package org.openjfx;

import classifier.*;
import com.dlsc.formsfx.model.structure.*;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.chart.ChartData;
import eu.hansolo.tilesfx.skins.BarChartItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Window;
import lyricAnalysis.LyricAnalysis;
import org.openjfx.ControllerClasses.FormBuilder;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;


public class Controller {

    private Classifier classifier;
    private DataSet oneHitWonders;
    private Boolean hitOrNot;
    private Integer probOfHitComparedToMiss;
    private DataTuple newHitTuple;
    private DataTuple newMissTuple;
    private LyricAnalysis lyricAnalysis;
    Image mainLogo;
    Image mainLogoRed;

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
    private Label mainTitle;

    @FXML
    private Tile ledTile;

    @FXML
    private Tile meter1;

    @FXML
    private Tile meter2;

    @FXML
    private Tile meter3;

    @FXML
    private Tile meter4;

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
    private VBox myPie;

    @FXML
    private VBox songMetrics;


    @FXML
    public void initialize() throws URISyntaxException {


        // AttributeRegistry.getInstance().updateAttributeDataSafely();
        try {
            AttributeRegistry.getInstance().updateAttributeDataFromARFF();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(AttributeRegistry.getInstance().printAttributesAndVals());
        oneHitWonders = new DataSet();
        //oneHitWonders.safeDataSet();
        oneHitWonders.buildDataSet();
        //  System.out.println(oneHitWonders.printOutDataSet());

        TupleBuilder tb = new TupleBuilder();
        newHitTuple = tb.getUnclassifiedHitTuple();
        newMissTuple = tb.getUnclassifiedMissTuple();

        classifier = new NaiveBayes(oneHitWonders);
//
//
//        /**
//         * Icon on classify button
//         */
        classifyIcon.setIcon(FontAwesomeIcon.CROSSHAIRS);
        classifyIcon.setSize("2em");
        classifyIcon.setFill(Color.LIGHTGRAY);
        classifyButton.setGraphic(classifyIcon);

//        iconView.setIcon(FontAwesomeIcon.AMBULANCE);
//        iconView.setSize("2em");
//        iconView.setFill(Color.CYAN);
//        popMe.setGraphic(iconView);


//        Alert a = new Alert(Alert.AlertType.NONE);


// here is where the logo goes
        mainLogo = new Image(getClass().getResource("Resources/1.png").toURI().toString());
        mainLogoRed = new Image(getClass().getResource("Resources/2.png").toURI().toString());
        imView.setImage(mainLogo);
        imView.setFitHeight(70);
        imView.setFitWidth(70);

//
        songAttributes = FormBuilder.buildSongAttributesForm();
        chordAttributes = FormBuilder.buildChordAttributesForm();
        toplineAttributes = FormBuilder.buildToplineAttributesForm();
        lyricAttributes = FormBuilder.buildLyricAttributesForm();


//        List elements = songAttributes.getElements();
//        SingleSelectionField tempo = (SingleSelectionField) elements.get(1);


        Label songAttrLab = new Label("Song Information");
        songAttrLab.getStyleClass().add("formHeadings");
        Label chordAttrLab = new Label("Chord Information");
        chordAttrLab.getStyleClass().add("formHeadings");
        Label toplineAttrLab = new Label("Topline Information");
        toplineAttrLab.getStyleClass().add("formHeadings");
        Label lyricalAttrLab = new Label("Lyrical Information");
        lyricalAttrLab.getStyleClass().add("formHeadings");


        forForm.getChildren().add(songAttrLab);
        forForm.getChildren().add(new FormRenderer(songAttributes));
        forForm.getChildren().add(chordAttrLab);
        forForm.getChildren().add(new FormRenderer(chordAttributes));
        forForm.getChildren().add(toplineAttrLab);
        forForm.getChildren().add(new FormRenderer(toplineAttributes));
        forForm.getChildren().add(lyricalAttrLab);
        forForm.getChildren().add(new FormRenderer(lyricAttributes));


        ChartData chartData1 = new ChartData("I-IV-V", 24.0, Tile.DARK_BLUE);
        ChartData chartData2 = new ChartData("i-VII-VI-VII", 10.0, Tile.BLUE);
        ChartData chartData3 = new ChartData("VI-VII-i-i", 12.0, Tile.GRAY);
        ChartData chartData4 = new ChartData("I-V-vi-IV", 13.0, Tile.GREEN);
        ChartData chartData5 = new ChartData("Item 5", 13.0, Tile.BLUE);
        ChartData chartData6 = new ChartData("Item 6", 13.0, Tile.BLUE);
        ChartData chartData7 = new ChartData("Item 7", 13.0, Tile.BLUE);
        ChartData chartData8 = new ChartData("Item 8", 13.0, Tile.BLUE);


        BarChartItem bc1 = new BarChartItem("Gmaj",20);
        BarChartItem bc2 = new BarChartItem("Amaj",30);
        BarChartItem bc3 = new BarChartItem("Bmaj",99);
        BarChartItem bc4 = new BarChartItem("Cmaj",7);

        meter2.addBarChartItem(bc1);
        meter2.addBarChartItem(bc2);
        meter2.addBarChartItem(bc3);
        meter2.addBarChartItem(bc4);

        Tile donutChartTile = TileBuilder.create()
                .skinType(Tile.SkinType.DONUT_CHART)
                .prefSize(800, 800)
                .title("Most Common Chords")
                .text("")
                .textVisible(false)
                .chartData(chartData1, chartData2, chartData3, chartData4)
                .build();

        myPie.getChildren().add(donutChartTile);


        gauge1.setValue(0);
        gauge1.setForegroundBaseColor(Color.AQUA);
        gauge1.setTitleColor(Color.WHITE);
        gauge1.setBarColor(Color.AQUA);
        gauge3.setValue(0);


    }

    @FXML
    public static void showStage() {
        HitSongDNA.LoadingPopup();
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

    private String[] assembleNewTuple() {
        String[] formTupleData = new String[35];
        List songAttr = songAttributes.getElements();
        List chrdAttr = chordAttributes.getElements();
        List topLnAttr = toplineAttributes.getElements();
        List lyrAttr = lyricAttributes.getElements();

        for (int i = 0; i < 4; i++) {
            SingleSelectionField sf = (SingleSelectionField) songAttr.get(i + 1);
            formTupleData[i] = (String) sf.getSelection();
        }
        SingleSelectionField sf2 = (SingleSelectionField) songAttr.get(5);
        formTupleData[25] = (String) sf2.getSelection();
        BooleanField sf3 = (BooleanField) songAttr.get(6);
        if (sf3.getValue()) {
            formTupleData[34] = "yes";
        } else formTupleData[34] = "no";

        SingleSelectionField keyVerse = (SingleSelectionField) chrdAttr.get(0);
        formTupleData[4] = (String) keyVerse.getSelection();
        SingleSelectionField vsChord = (SingleSelectionField) chrdAttr.get(1);
        formTupleData[5] = (String) vsChord.getSelection();
        BooleanField vsStart1 = (BooleanField) chrdAttr.get(2);
        formTupleData[6] = vsStart1.getValue().toString().toUpperCase();
        for (int i = 3; i < 6; i++) {
            SingleSelectionField sf4 = (SingleSelectionField) chrdAttr.get(i);
            formTupleData[i + 4] = (String) sf4.getSelection();
        }
        BooleanField vsChSame = (BooleanField) chrdAttr.get(6);
        formTupleData[10] = String.valueOf(vsChSame.getValue()).toUpperCase();
        BooleanField vsKeyCh = (BooleanField) chrdAttr.get(7);
        if (vsKeyCh.getValue()) {
            formTupleData[11] = "yes";
        } else formTupleData[11] = "no";
        SingleSelectionField chChord = (SingleSelectionField) chrdAttr.get(8);
        formTupleData[12] = (String) chChord.getSelection();
        BooleanField chStart = (BooleanField) chrdAttr.get(9);
        formTupleData[13] = String.valueOf(chStart.getValue()).toUpperCase();

        for (int i = 10; i < 13; i++) {
            SingleSelectionField sf5 = (SingleSelectionField) chrdAttr.get(i);
            formTupleData[i + 4] = (String) sf5.getSelection();
        }

        for (int i = 0; i < 8; i++) {
            SingleSelectionField sf6 = (SingleSelectionField) topLnAttr.get(i);
            formTupleData[i + 17] = (String) sf6.getSelection();
        }


        /**
         *
         * some body lyric values for now
         */
        StringField title = (StringField) songAttr.get(0);
        StringField lyricsPasted = (StringField) lyrAttr.get(0);
        lyricAnalysis = new LyricAnalysis(title.getValue(), lyricsPasted.getValue());

        //processLyrics(lyricsPasted.getValue());
        formTupleData[26] = lyricAnalysis.getLineRepeatString();
        formTupleData[27] = lyricAnalysis.getGradeLevelString();
        formTupleData[28] = lyricAnalysis.getTotalNumberOfWordsString();
        formTupleData[29] = lyricAnalysis.getSongTitleRepeatString();
        formTupleData[30] = lyricAnalysis.getNumberOfDistinctHitWordString();
        formTupleData[31] = lyricAnalysis.getTotalNumberOfHitWordsString();

        lyricAnalysis.showAllLyricData();


        SingleSelectionField rhyme = (SingleSelectionField) lyrAttr.get(1);
        formTupleData[32] = (String) rhyme.getSelection();
        SingleSelectionField arche = (SingleSelectionField) lyrAttr.get(2);
        formTupleData[33] = (String) arche.getSelection();
        return formTupleData;
    }

//    private void processLyrics(String lyricsPasted) {
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter("lyrics.txt", false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        try {
//            bufferedWriter.write(lyricsPasted);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(lyricsPasted);
//    }

    @FXML
    public void executeClassification() {


        if (songAttributes.isValid() &&
                chordAttributes.isValid() &&
                lyricAttributes.isValid() &&
                toplineAttributes.isValid()) {
            String[] tupleData;
            tupleData = assembleNewTuple();

            DataTuple newSongFromUser = new DataTuple(tupleData);
            hitOrNot = classifier.songIsLikelyToBeAHit(newSongFromUser);
            probOfHitComparedToMiss = classifier.percentage();


            try {
                if (hitOrNot) {
                    gauge1.setValue(probOfHitComparedToMiss);
                    gauge1.setForegroundBaseColor(Color.AQUA);
                    gauge1.setTitleColor(Color.WHITE);
                    gauge1.setBarColor(Color.AQUA);
                    gauge3.setVisible(true);
                    gauge3.setValue(62);
                    mainTitle.setStyle("-fx-text-fill: cyan;");
                    hitLabel.setStyle("-fx-text-fill: cyan;");
                    imView.setImage(mainLogo);
                    ledTile.setActive(true);
                    ledTile.setActiveColor(Color.CYAN);
                    hitLabel.setText("HIT");
                }
                if (!hitOrNot) {
                    gauge1.setValue(probOfHitComparedToMiss);
                    gauge1.setForegroundBaseColor(Color.DARKRED);
                    gauge1.setBarColor(Color.DARKRED);
                    mainTitle.setStyle("-fx-text-fill: red;");
                    imView.setImage(mainLogoRed);
                    gauge1.setValueColor(Color.RED);
                    gauge3.setVisible(false);
                    ledTile.setActive(true);
                    ledTile.setActiveColor(Color.RED);
                    hitLabel.setStyle("-fx-text-fill: red;");
                    hitLabel.setText("MISS");

                }
            } catch (Exception exception) {
                formIncompletePopup();
            }
        } else {
            formIncompletePopup();
        }

    }


    public static void showPopup2(Window win) {
        Popup popup = new Popup();
        popup.setX(300);
        popup.setY(200);
        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));
        popup.show(win);
    }


    private void formIncompletePopup() {

        Alert pu2 = new Alert(Alert.AlertType.ERROR);

        DialogPane dialogPane = pu2.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("Resources/dialog.css").toExternalForm());
        dialogPane.getStyleClass().add("dialogs");

        pu2.setContentText("You will need a complete form to continue");
        pu2.setHeaderText("Incomplete Song Data");
        pu2.setTitle("Error!");
        pu2.show();

    }
}
