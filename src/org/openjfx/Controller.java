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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import lyricAnalysis.LyricAnalysis;

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
        AttributeRegistry.getInstance().updateAttributeDataSafely();
        //System.out.println(AttributeRegistry.getInstance().printAttributesAndVals());
        oneHitWonders = new DataSet();
        oneHitWonders.safeDataSet();
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
        classifyIcon.setIcon(FontAwesomeIcon.PIED_PIPER_PP);
        classifyIcon.setSize("2em");
        classifyIcon.setFill(Color.LIGHTGRAY);
        classifyButton.setGraphic(classifyIcon);

//        iconView.setIcon(FontAwesomeIcon.AMBULANCE);
//        iconView.setSize("2em");
//        iconView.setFill(Color.CYAN);
//        popMe.setGraphic(iconView);


//        Alert a = new Alert(Alert.AlertType.NONE);


// here is where the logo goes
        Image image = new Image(getClass().getResource("Resources/1.png").toURI().toString());
        imView.setImage(image);
        imView.setFitHeight(70);
        imView.setFitWidth(70);

//
        songAttributes = buildSongAttributesForm();
        chordAttributes = buildChordAttributesForm();
        toplineAttributes = buildToplineAttributesForm();
        lyricAttributes = buildLyricAttributesForm();

        forForm.getChildren().add(new Label("Song Attributes"));
        forForm.getChildren().add(new FormRenderer(songAttributes));
        forForm.getChildren().add(new Label("Chord Information"));
        forForm.getChildren().add(new FormRenderer(chordAttributes));
        forForm.getChildren().add(new Label("Topline Information"));
        forForm.getChildren().add(new FormRenderer(toplineAttributes));
        forForm.getChildren().add(new Label("Lyrical Information"));
        forForm.getChildren().add(new FormRenderer(lyricAttributes));


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
                    gauge3.setValue(63);
                    hitLabel.setStyle("-fx-text-fill: cyan;");
                    ledTile.setActive(true);
                    ledTile.setActiveColor(Color.CYAN);
                    hitLabel.setText("HIT");
                }
                if (!hitOrNot) {
                    gauge1.setValue(probOfHitComparedToMiss);
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


    private Form buildSongAttributesForm() {

        return Form.of(
                Group.of(
                        Field.ofStringType("")
                                .label("Song Title")
                                .required("")
                                .tooltip("The title of your song.")
                                .placeholder("Please enter the title of your song here."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("INTRO_LEN"))
                                .label("Intro Length")
                                .required("Please select the range in seconds that the intro of your song fits into."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("TEMPO"))
                                .label("Tempo")
                                .required("Please select the tempo range of your song"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("GENRE"))
                                .label("Genre")
                                .required("Please select the Genre of your song from the following."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("LEAD_SING"))
                                .label("Lead Singer(s)")
                                .required("Please select type of Voice(s) featured in your song."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("DRUM_PAT"))
                                .label("Drum Pattern")
                                .required("Please select from the range of fundamental drum patters."),
                        Field.ofBooleanType(false)
                                .label("Co-writer with Top 40 history")
                                .tooltip("If any of the co-writers have had a top 40 charting song please select yes.")
                )
        );

    }

    private Form buildChordAttributesForm() {
        return Form.of(
                Group.of(
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("KEY_VS"))
                                .label("Key of Verse")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CHORDS_VS"))
                                .label("Vs Chord Progression")
                                .required("This field can’t be empty"),
                        Field.ofBooleanType(false)
                                .label("Verse Starts on Chord I"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("IONIAN_VS_KEY"))
                                .label("Verse Key Ionian")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("IONIAN_VS_CHORDS"))
                                .label("Verse Chords Ionian")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_DISTINCT_CHRD_COUNT"))
                                .label("Vs Chordcount")
                                .required("This field can’t be empty"),
                        Field.ofBooleanType(false)
                                .label("Vs/Ch same chords"),
                        Field.ofBooleanType(false)
                                .label("Vs has Key Change"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CHORDS_CH"))
                                .label("Ch Chord Progression")
                                .required("This field can’t be empty"),
                        Field.ofBooleanType(false)
                                .label("Chorus Starts on Chord I"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("IONIAN_CH_CHORDS"))
                                .label("Ch Chords Ionian")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_DISTINCT_CHRD_COUNT"))
                                .label("Ch Chordcount")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("SONG_TOTAL_CHORD_COUNT"))
                                .label("Total chords used")
                                .required("This field can’t be empty"))
        );
    }


    private Form buildToplineAttributesForm() {
        return Form.of(
                Group.of(
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TOPLINE"))
                                .label("Vs Topline")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TL_START_NOTE"))
                                .label("Vs Topline start note")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TL_DISTINCT_NOTES"))
                                .label("Vs No. notes in Topline")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TL_TYPE"))
                                .label("Vs Topline Type")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TOPLINE"))
                                .label("Ch Topline")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TL_START_NOTE"))
                                .label("Ch Topline start note")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TL_DISTINCT_NOTES"))
                                .label("Ch No. notes in Topline")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TL_TYPE"))
                                .label("Ch Topline Type")
                                .required("This field can’t be empty")
                )
        );
    }

    private Form buildLyricAttributesForm() {
        return Form.of(
                Group.of(
                        Field.ofStringType("")
                                .multiline(true)
                                .required("This field can’t be empty")
                                .label("Paste Lyrics"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("RHYMECOUNT"))
                                .label("Rhymecount")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("LYR_ARCHETYPE"))
                                .label("Lyrical Archetype")
                                .required("This field can’t be empty")
                )
        );
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
