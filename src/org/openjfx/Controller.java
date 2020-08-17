package org.openjfx;

import classifier.*;
import com.dlsc.formsfx.model.structure.BooleanField;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.SingleSelectionField;
import com.dlsc.formsfx.model.structure.StringField;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.skins.BarChartItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private Tab tab1;

    @FXML
    private Tab tab2;

    @FXML
    private Tab tab3;

    @FXML
    private Tab tab4;

    @FXML
    private ImageView imView;

    @FXML
    private FontAwesomeIconView classifyIcon;


    @FXML
    private void aboutPopup(ActionEvent event) {
        Alert pu2 = new Alert(Alert.AlertType.INFORMATION);
        pu2.setContentText("2020 Hit Song Prediction & Metrics");
        pu2.setHeaderText("HitSongDNA");
        pu2.setTitle("HitSongDNA");
        pu2.show();
    }

    @FXML
    private void exitProg(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private Label hitLabel;

    @FXML
    private Label mainTitle;

    @FXML
    private Tile ledTile;

    @FXML
    private TableView attributeTable;


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
    private Button saveButton;


    @FXML
    private Button clearButton;
    @FXML
    private Button retrieveButton;


    @FXML
    private Button deleteButton;


    @FXML
    private Gauge gauge1;

    @FXML
    private Gauge gauge3;

    @FXML
    private Gauge dMGauge1;

    @FXML
    private Gauge dMGauge2;

    @FXML
    private Gauge dMGauge3;

    @FXML
    private Gauge dMGauge4;

    @FXML
    private Gauge dMGauge5;

    @FXML
    private Gauge dMGauge6;

    @FXML
    private VBox forForm;

    @FXML
    private VBox songMetrics;

    private void buildClassifyButton() {

        classifyIcon.setIcon(FontAwesomeIcon.PLAY);
        classifyIcon.setSize("2em");
        classifyIcon.setFill(Color.LIGHTGRAY);
        classifyButton.setGraphic(classifyIcon);
        classifyButton.setContentDisplay(ContentDisplay.RIGHT);

        classifyButton.setOnMouseEntered(e -> {
            classifyIcon.setFill(Color.CYAN);
        });
        classifyButton.setOnMouseExited(e -> {
            classifyIcon.setFill(Color.LIGHTGRAY);
        });
    }

    private void buildPredictionButtons() {

        // clear button
        FontAwesomeIconView clearIcon = new FontAwesomeIconView();
        clearIcon.setIcon(FontAwesomeIcon.TIMES_CIRCLE);
        clearIcon.setSize("1em");
        clearIcon.setFill(Color.LIGHTGRAY);
        clearButton.setGraphic(clearIcon);
        clearButton.setContentDisplay(ContentDisplay.RIGHT);
        clearButton.setTooltip(new Tooltip("Reset all form fields"));
        clearButton.setOnAction(e -> {
            songAttributes.reset();
            chordAttributes.reset();
            lyricAttributes.reset();
            toplineAttributes.reset();
            genericPopup("Form Reset", "Form reset!");
        });

        FontAwesomeIconView saveIcon = new FontAwesomeIconView();
        saveIcon.setIcon(FontAwesomeIcon.SAVE);
        saveIcon.setSize("1em");
        saveIcon.setFill(Color.LIGHTGRAY);
        saveButton.setGraphic(saveIcon);
        saveButton.setTooltip(new Tooltip("Save progress to 'My Songs'"));
        saveButton.setContentDisplay(ContentDisplay.RIGHT);
        saveButton.setTooltip(new Tooltip("Save draft of form"));
        saveButton.setOnAction(e->{
            saveFormDraft();
        });

    }

    private void saveFormDraft(){
        genericPopup("Draft saved!", "");
    }

    @FXML
    public void initialize() throws URISyntaxException {


        try {
            AttributeRegistry.getInstance().updateAttributeDataFromARFF();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        oneHitWonders = new DataSet();
        classifier = new NaiveBayes(oneHitWonders);

        setupTabs();
        buildClassifyButton();
        buildPredictionButtons();




        FontAwesomeIconView retrieveIcon = new FontAwesomeIconView();
        retrieveIcon.setIcon(FontAwesomeIcon.CHECK_CIRCLE);
        retrieveIcon.setSize("1em");
        retrieveIcon.setFill(Color.LIGHTGRAY);
        retrieveButton.setGraphic(retrieveIcon);

        FontAwesomeIconView deleteIcon = new FontAwesomeIconView();
        deleteIcon.setIcon(FontAwesomeIcon.REMOVE);
        deleteIcon.setSize("1em");
        deleteIcon.setFill(Color.LIGHTGRAY);
        deleteButton.setGraphic(deleteIcon);


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


        BarChartItem bc1 = new BarChartItem("Gmaj", 20);
        BarChartItem bc2 = new BarChartItem("Amaj", 30);
        BarChartItem bc3 = new BarChartItem("Bmaj", 99);
        BarChartItem bc4 = new BarChartItem("Cmaj", 7);

//        meter2.addBarChartItem(bc1);
//        meter2.addBarChartItem(bc2);
//        meter2.addBarChartItem(bc3);
//        meter2.addBarChartItem(bc4);


        gauge1.setValue(0);
        gauge1.setForegroundBaseColor(Color.AQUA);
        gauge1.setTitleColor(Color.WHITE);
        gauge1.setBarColor(Color.AQUA);
        gauge3.setValue(0);

        dMGauge1.setValue(74);
        dMGauge1.setForegroundBaseColor(Color.AQUA);
        dMGauge1.setTitleColor(Color.WHITE);
        dMGauge1.setBarColor(Color.AQUA);
        dMGauge1.setTitle("<80bpm");

        dMGauge2.setValue(23);
        dMGauge2.setForegroundBaseColor(Color.RED);
        dMGauge2.setTitleColor(Color.WHITE);
        dMGauge2.setBarColor(Color.RED);
        dMGauge2.setTitle("80-95bpm");

        dMGauge3.setValue(56);
        dMGauge3.setForegroundBaseColor(Color.AQUA);
        dMGauge3.setTitleColor(Color.WHITE);
        dMGauge3.setBarColor(Color.AQUA);
        dMGauge3.setTitle("95-110bpm");


        dMGauge4.setValue(90);
        dMGauge4.setForegroundBaseColor(Color.AQUA);
        dMGauge4.setTitleColor(Color.WHITE);
        dMGauge4.setBarColor(Color.AQUA);
        dMGauge4.setTitle("111-120bpm");

        dMGauge5.setValue(12);
        dMGauge5.setForegroundBaseColor(Color.RED);
        dMGauge5.setTitleColor(Color.WHITE);
        dMGauge5.setBarColor(Color.RED);
        dMGauge5.setTitle("121-130bpm");


        dMGauge6.setValue(77);
        dMGauge6.setForegroundBaseColor(Color.AQUA);
        dMGauge6.setTitleColor(Color.WHITE);
        dMGauge6.setBarColor(Color.AQUA);
        dMGauge6.setTitle(">130bpm");


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

    private void genericPopup(String title, String message) {
        Alert genPop = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = genPop.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("Resources/dialog.css").toExternalForm());
        dialogPane.getStyleClass().add("dialogs");
        genPop.setContentText(message);
        genPop.setHeaderText(title);
        genPop.setTitle(title);
        genPop.show();

    }

    private void setupTabs() {

        FontAwesomeIconView tab1Icon = new FontAwesomeIconView();
        FontAwesomeIconView tab2Icon = new FontAwesomeIconView();
        FontAwesomeIconView tab3Icon = new FontAwesomeIconView();
        FontAwesomeIconView tab4Icon = new FontAwesomeIconView();

        tab1Icon.setIcon(FontAwesomeIcon.DASHBOARD);
        tab1Icon.setSize("1em");
        tab1Icon.setFill(Color.LIGHTGRAY);
        tab1.setGraphic(tab1Icon);

        tab2Icon.setIcon(FontAwesomeIcon.BAR_CHART);
        tab2Icon.setSize("1em");
        tab2Icon.setFill(Color.LIGHTGRAY);
        tab2.setGraphic(tab2Icon);

        tab3Icon.setIcon(FontAwesomeIcon.MUSIC);
        tab3Icon.setSize("1em");
        tab3Icon.setFill(Color.LIGHTGRAY);
        tab3.setGraphic(tab3Icon);

        tab4Icon.setIcon(FontAwesomeIcon.SAVE);
        tab4Icon.setSize("1em");
        tab4Icon.setFill(Color.LIGHTGRAY);
        tab4.setGraphic(tab4Icon);

    }
}
