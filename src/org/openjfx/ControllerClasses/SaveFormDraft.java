package org.openjfx.ControllerClasses;

import com.dlsc.formsfx.model.structure.BooleanField;
import com.dlsc.formsfx.model.structure.SingleSelectionField;
import com.dlsc.formsfx.model.structure.StringField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveFormDraft {
    public static void save(List allfields, List allChordFields, List allToplineFields, List allLyricFields) {

        StringField title = (StringField) allfields.get(0);
        SingleSelectionField intro = (SingleSelectionField) allfields.get(1);
        SingleSelectionField tempo = (SingleSelectionField) allfields.get(2);
        SingleSelectionField genre = (SingleSelectionField) allfields.get(3);
        SingleSelectionField singer = (SingleSelectionField) allfields.get(4);
        SingleSelectionField beat = (SingleSelectionField) allfields.get(5);
        BooleanField cowriter = (BooleanField) allfields.get(6);
        SingleSelectionField key_vs = (SingleSelectionField) allChordFields.get(0);
        SingleSelectionField vs_chords = (SingleSelectionField) allChordFields.get(1);
        BooleanField vs_start_chord = (BooleanField) allChordFields.get(2);
        SingleSelectionField vs_ionian_key = (SingleSelectionField) allChordFields.get(3);
        SingleSelectionField vs_ionian_ch = (SingleSelectionField) allChordFields.get(4);
        SingleSelectionField vs_ch_count = (SingleSelectionField) allChordFields.get(5);
        BooleanField vs_ch_same = (BooleanField) allChordFields.get(6);
        BooleanField vs_key_chng = (BooleanField) allChordFields.get(7);
        SingleSelectionField ch_chords = (SingleSelectionField) allChordFields.get(8);
        BooleanField ch_starts_I = (BooleanField) allChordFields.get(9);
        SingleSelectionField ch_ionian_ch = (SingleSelectionField) allChordFields.get(10);
        SingleSelectionField ch_ch_count = (SingleSelectionField) allChordFields.get(11);
        SingleSelectionField total_ch_count = (SingleSelectionField) allChordFields.get(12);
        SingleSelectionField vs_tl = (SingleSelectionField) allToplineFields.get(0);
        SingleSelectionField vs_tl_start = (SingleSelectionField) allToplineFields.get(1);
        SingleSelectionField vs_tl_noteCount = (SingleSelectionField) allToplineFields.get(2);
        SingleSelectionField vs_tl_type = (SingleSelectionField) allToplineFields.get(3);
        SingleSelectionField ch_tl = (SingleSelectionField) allToplineFields.get(4);
        SingleSelectionField ch_tl_start = (SingleSelectionField) allToplineFields.get(5);
        SingleSelectionField ch_tl_noteCount = (SingleSelectionField) allToplineFields.get(6);
        SingleSelectionField ch_tl_type = (SingleSelectionField) allToplineFields.get(7);
        StringField lyrics = (StringField) allLyricFields.get(0);
        String stripCommas = lyrics.getValue();
        stripCommas = stripCommas.replaceAll(",", "\n");
        SingleSelectionField rhymecount = (SingleSelectionField) allLyricFields.get(1);
        SingleSelectionField archetype = (SingleSelectionField) allLyricFields.get(2);

        String songData = "@" + title.getValue() + ","
                + intro.getSelection() + ","
                + tempo.getSelection() + ","
                + genre.getSelection() + ","
                + singer.getSelection() + ","
                + beat.getSelection() + ","
                + cowriter.getValue() + ","
                + key_vs.getSelection() + ","
                + vs_chords.getSelection() + ","
                + vs_start_chord.getValue() + ","
                + vs_ionian_key.getSelection() + ","
                + vs_ionian_ch.getSelection() + ","
                + vs_ch_count.getSelection() + ","
                + vs_ch_same.getValue() + ","
                + vs_key_chng.getValue() + ","
                + ch_chords.getSelection() + ","
                + ch_starts_I.getValue() + ","
                + ch_ionian_ch.getSelection() + ","
                + ch_ch_count.getSelection() + ","
                + total_ch_count.getSelection() + ","
                + vs_tl.getSelection() + ","
                + vs_tl_start.getSelection() + ","
                + vs_tl_noteCount.getSelection() + ","
                + vs_tl_type.getSelection() + ","
                + ch_tl.getSelection() + ","
                + ch_tl_start.getSelection() + ","
                + ch_tl_noteCount.getSelection() + ","
                + ch_tl_type.getSelection() + ","
                + stripCommas + ","
                + rhymecount.getSelection() + ","
                + archetype.getSelection() + ",";


        // System.out.println(songData);

        String filePath = System.getProperty("user.home");
        String filename = "HitSongDNA_user_song_data.hsd";
        filePath += File.separator + "Documents" + File.separator + filename;
        // System.out.println(filePath);

        // check if file exists
//
        File tmpDir = new File(filePath);
        boolean exists = tmpDir.exists();

        if (!exists) {
            // Write the content in file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(songData);
            } catch (IOException e) {
                // Exception handling
            }
        } else {

            // Write the content in file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.newLine();
                writer.write(songData);
            } catch (IOException e) {
                // Exception handling
            }
        }

    }
}
