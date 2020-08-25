package org.openjfx.ControllerClasses;

import classifier.AttributeRegistry;
import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.util.ColSpan;

import java.util.List;

public class FormBuilder {


    public static Form buildSongAttributesForm(String songTitle) {


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
                                .required("Please select the tempo range of your song.")
                                .valueDescription("Please enter your songs Tempo.")
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
                                .valueDescription("Please choose fundamental beat."),

                        Field.ofBooleanType(false)
                                .label("Co-writer")
                                .tooltip("Select if any of the co-writers have had a top 40 charting song.")
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
        return buildSongAttributesForm("");
    }

    public static Form buildChordAttributesForm() {

        Form newForm;
        newForm = Form.of(
                Group.of(
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("KEY_VS"))
                                .label("Vs Key")
                                .required("The key signature of the verse i.e A major.")
//                                .tooltip("The key signature of the verse i.e A major.")
                                .valueDescription("Please enter the key of the verse."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CHORDS_VS"))
                                .label("Vs Chord")
                                .labelDescription("Sequence")
                                .required("The verse chord sequence in Roman Numerals. Select NTP if your song pattern isn't in the list.")
//                                .tooltip("The verse chord sequence in Roman Numerals. Select NTP if your song pattern isn't in the list.")
                                .valueDescription("Please select the verse chord sequence."),
                        Field.ofBooleanType(false)
                                .label("Vs Starts ")
                                .labelDescription("on Chord I")
//                                .tooltip("Select this if the Verse starts on Chord I of the Key.i.e The key is Amajor and the first chord is an Amaj chord.")
                                .valueDescription("Does the verse start on chord I?"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("IONIAN_VS_KEY"))
                                .label("Vs Key")
                                .labelDescription("Rel-Major")
                                .required("The relative major key of the Verse i.e F# minor becomes A major.")
//                                .tooltip("The relative major key of the Verse i.e F# minor becomes A major.")
                                .valueDescription("Please enter the Relative-Major key of the verse."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("IONIAN_VS_CHORDS"))
                                .label("Vs Chords")
                                .labelDescription("Rel-Major")
                                .required("The relative major version of the chords i.e i-i-iv-v becomes vi-vi-ii-iii.")
//                                .tooltip("The relative major version of the chords i.e i-i-iv-v becomes vi-vi-ii-iii.")
                                .valueDescription("Please enter the relative major chords of the verse."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_DISTINCT_CHRD_COUNT"))
                                .label("Verse no. ")
                                .labelDescription("of Chords")
                                .required("The total number of different chords used in the verse.")
//                                .tooltip("The total number of different chords used in the verse.")
                                .valueDescription("Please enter the number of different chords used in the verse."),
                        Field.ofBooleanType(false)
                                .label("Vs & Ch have")
                                .labelDescription("Same Chords")
//                                .tooltip("Select if the verse and chorus use the same chords, even if the vocal melody changes..")
                                .valueDescription("Does the verse and chorus use the same chord sequence?")
                        ,
                        Field.ofBooleanType(false)
                                .label("Vs has")
                                .labelDescription("key change")
//                                .tooltip("If the verse has any kind of key change check this box..")
                                .valueDescription("Does the verse change key at any point?"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CHORDS_CH"))
                                .label("Ch Chord")
                                .labelDescription("Sequence")
                                .required("The chorus chord sequence in Roman Numerals. Select NTP if your song pattern isn't in the list.")

                                .valueDescription("Please select the chorus chord sequence."),
                        Field.ofBooleanType(false)
                                .label("Ch Starts ")
                                .labelDescription("on Chord I")
//                                .tooltip("Select this if the chorus starts on Chord I of the Key.i.e The key is Amajor and the first chord is an Amaj chord.")
                                .valueDescription("Does the chorus start on chord I?"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("IONIAN_CH_CHORDS"))
                                .label("Ch Chords")
                                .labelDescription("Rel-Major")
                                .required("The relative major version of the chorus chords i.e i-i-iv-v becomes vi-vi-ii-iii.")
//                                .tooltip("The relative major version of the chorus chords i.e i-i-iv-v becomes vi-vi-ii-iii.")
                                .valueDescription("Please enter the relative major chords of the chorus."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_DISTINCT_CHRD_COUNT"))
                                .label("Chorus no. ")
                                .labelDescription("of Chords")
                                .required("The total number of different chords used in the chorus.")
                                .valueDescription("Please enter the number of different chords used in the chorus.")
                        ,
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("SONG_TOTAL_CHORD_COUNT"))
                                .label("Total song")
                                .labelDescription("Chords")
                                .required("The total number of different chords used in the song.")
                                .valueDescription("Please enter the total number of different chords used throughout the song.")

//                                .tooltip("The total number of different chords used in the song.")
                )
        );

        return assignCSSClass(newForm);

    }

    public static Form buildToplineAttributesForm() {

        Form newForm;
        newForm = Form.of(
                Group.of(
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TOPLINE"))
                                .label("Vs Topline")
                                .labelDescription("sequence")
                                .required("This is the interval of your main verse melody note over each chord in the progression. \n" +
                                        "For example if the chord is Gmaj and you are singing a B.. that is a 3." +
                                        " \nThere are 4 chords, therefore 4 topline intervals. If your chords are G-G-E-E, \n" +
                                        "and you sing a B note " +
                                        "the whole way through, you will get B over G, which is a '3'. " +
                                        "\nSinging the B over E is a '5'. Your sequence would then be 3-3-5-5 over G-G-E-E.")
                                .valueDescription("Please enter the topline-to-chord interval relationship sequence."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TL_START_NOTE"))
                                .label("Vs Topline")
                                .labelDescription("First Note")
                                .required("This is the interval of the vocal melody's first note over the first chord. \n" +
                                        "If your first chord is C and you are singing a C that is a root, or a 1. \n" +
                                        "If you are singing an E over C that is a third or 3.")
                                .valueDescription("Please enter the interval of your verse vocal melody's starting note over the first chord."),

                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TL_DISTINCT_NOTES"))
                                .label("Vs Topline")
                                .labelDescription("No. Notes")
                                .required("If your topline sequence is 1-1-1-1 that is then 1, if it is 1-3-5-5 that would be 3.")
                                .valueDescription("Please enter the number of different fundamental notes used in your verse topline melody.")
                        ,
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("VS_TL_TYPE"))
                                .label("Vs Topline")
                                .labelDescription("Type")
                                .valueDescription("Please enter the type of vocal melody notes used in the topline.")
                                .required("Triad-notes are where your vocal line consists of 1,3,5 only. Mixed-Harm is when it contains 2,4,6 as well."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TOPLINE"))
                                .label("Ch Topline")
                                .labelDescription("sequence")
                                .required("This is the interval of your main chorus melody note over each chord in the progression. \n" +
                                        "For example if the chord is Gmaj and you are singing a B.. that is a 3." +
                                        " \nThere are 4 chords, therefore 4 topline intervals. If your chords are G-G-E-E, \n" +
                                        "and you sing a B note " +
                                        "the whole way through, you will get B over G, which is a '3'. " +
                                        "\nSinging the B over E is a '5'. Your sequence would then be 3-3-5-5 over G-G-E-E.")
                                .valueDescription("Please enter the topline-to-chord interval relationship sequence."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TL_START_NOTE"))
                                .label("Ch Topline")
                                .labelDescription("First Note")
                                .required("This is the interval of the vocal melody's first note over the first chord. \n" +
                                        "If your first chord is C and you are singing a C that is a root, or a 1. \n" +
                                        "If you are singing an E over C that is a third or 3.")
                                .valueDescription("Please enter the interval of your chorus vocal melody's starting note over the first chord."),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TL_DISTINCT_NOTES"))
                                .label("Ch Topline")
                                .labelDescription("No. Notes")
                                .required("If your topline sequence is 1-1-1-1 that is then 1, if it is 1-3-5-5 that would be 3.")
                                .valueDescription("Please enter the number of different fundamental notes used in your chorus topline melody.")
                        ,
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("CH_TL_TYPE"))
                                .label("Ch Topline")
                                .labelDescription("Type")
                                .valueDescription("Please enter the type of vocal melody notes used in the chorus topline.")
                                .required("Triad-notes are where your vocal line consists of 1,3,5 only. Mixed-Harm is when it contains 2,4,6 as well."))
        );
        return assignCSSClass(newForm);
    }

    public static Form buildLyricAttributesForm(String songLyrics) {
        Form newForm;
        newForm = Form.of(
                Group.of(
                        Field.ofStringType(songLyrics)
                                .multiline(true)
                                .required("")
                                .tooltip("Paste your lyrics into this box making sure each line begins on a new line.")
                                .valueDescription("Please paste the lyrics for your song into this field.")

                                .label("lyrics"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("RHYMECOUNT"))
                                .label("Rhymecount")
                                .required("This field can’t be empty"),
                        Field.ofSingleSelectionType(AttributeRegistry.getInstance().getValues("LYR_ARCHETYPE"))
                                .label("Lyrical")
                                .labelDescription("Archetype")
                                .required("Select the lyrical archetype that best matches the meaning of your song lyrics.\n" +
                                        "Guidance on 'Archetypes' can be found in the 'Help' drop down menu.")
                                .valueDescription("Select the lyrical archetype your song lyrics best fit to")
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
