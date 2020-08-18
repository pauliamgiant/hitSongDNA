package org.openjfx.ControllerClasses;

import classifier.AttributeRegistry;
import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.util.ColSpan;

import java.util.List;

public class FormBuilder {


    public static Form buildSongAttributesForm(String songTitle){


        Form newForm;
        newForm = Form.of(
                Group.of(
                        Field.ofStringType(songTitle)

                                .label("Title")
                                .styleClass("changeLabel")
                                .required("")
                                .tooltip("The title of your song.")
                                .valueDescription("Please enter the title of your song here."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("INTRO_LEN"))
                                .label("Intro")
                                .required("This is the length of your intro as measured in seconds.")
                                .valueDescription("Please enter the length of the song in seconds."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("TEMPO"))
                                .label("Tempo")
                                .required("Please select the tempo range of your song")
                                .valueDescription("Please enter your songs Tempo")
                                .span(ColSpan.HALF),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("GENRE"))
                                .label("Genre")
                                .required("Please select the Genre of your song from the following.").span(ColSpan.HALF)
                                .valueDescription("Please enter Genre."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("LEAD_SING"))
                                .label("Singer")
                                .required("Please select type of Voice(s) featured in your song.")
                                .valueDescription("Please enter voice format of Lead Vocalist(s)."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("DRUM_PAT"))
                                .label("Beat")
                                .required("Please select from the range of fundamental drum patters.").span(ColSpan.HALF)
                                .valueDescription("Please choose fundamental beat"),

                        Field.ofBooleanType(false)
                                .label("Co-writer")
                                .tooltip("If any of the co-writers have had a top 40 charting song please select yes.")
                                .span(ColSpan.HALF)
                                .valueDescription("Top 40 co-writer?")
                )
        );
        List fields = newForm.getFields();

        for (Object o : fields
        ) {
            Field f = (Field) o;
            f.getStyleClass().add("changeLabel");
            if (f.getValueDescription() != null) {
                f.getValueDescription().getStyleClass().remove("label");
                f.getValueDescription().getStyleClass().add("changeMe");
            }
            Field textField = (Field) fields.get(0);
            textField.id("grabTitle");
        }
        return newForm;

    }



    public static Form buildSongAttributesForm() {
       return  buildSongAttributesForm("");
    }

    public static Form buildChordAttributesForm() {

        Form newForm;
        newForm = Form.of(
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

        return assignCSSClass(newForm);

    }

    public static Form buildToplineAttributesForm() {

        Form newForm;
        newForm = Form.of(
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
                                .required("This field can’t be empty"))
        );
        return assignCSSClass(newForm);
    }

    public static Form buildLyricAttributesForm(String songLyrics){
        Form newForm;
        newForm = Form.of(
                Group.of(
                        Field.ofStringType(songLyrics)
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
        List fields = newForm.getFields();
        Field textField = (Field) fields.get(0);
        textField.id("grabTitle2");

        return assignCSSClass(newForm);

    }

    public static Form buildLyricAttributesForm() {
        return buildLyricAttributesForm("");
    }


    private static Form assignCSSClass(Form newForm) {
        List fields = newForm.getFields();

        for (Object o : fields
        ) {
            Field f = (Field) o;
            f.getStyleClass().add("changeLabel");
            if (f.getValueDescription() != null) {
                f.getValueDescription().getStyleClass().remove("label");
                f.getValueDescription().getStyleClass().add("changeMe");
            }
        }
        return newForm;
    }
}
