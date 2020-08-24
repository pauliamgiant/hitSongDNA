package org.openjfx.ControllerClasses;

import com.dlsc.formsfx.model.structure.BooleanField;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.SingleSelectionField;

public class FormLoader {

    public static Form[] reloadForm(String songCSVData) {

        Form[] reloadedFormParts = new Form[4];

        String[] values = songCSVData.split(",");
        String titleClean = values[0].substring(1);
        Form songAttributes = FormBuilder.buildSongAttributesForm(titleClean);


        if (!values[1].equals("null")) {
            SingleSelectionField sf = (SingleSelectionField) songAttributes.getElements().get(1);
            sf.selectionProperty().set(values[1]);
        }
        if (!values[2].equals("null")) {
            SingleSelectionField sf2 = (SingleSelectionField) songAttributes.getElements().get(2);
            sf2.selectionProperty().set(values[2]);
        }
        if (!values[3].equals("null")) {
            SingleSelectionField sf3 = (SingleSelectionField) songAttributes.getElements().get(3);
            sf3.selectionProperty().set(values[3]);
        }
        if (!values[4].equals("null")) {
            SingleSelectionField sf4 = (SingleSelectionField) songAttributes.getElements().get(4);
            sf4.selectionProperty().set(values[4]);
        }
        if (!values[5].equals("null")) {
            SingleSelectionField sf5 = (SingleSelectionField) songAttributes.getElements().get(5);
            sf5.selectionProperty().set(values[5]);
        }
        if (values[6].equals("true")) {
            BooleanField bf1 = (BooleanField) songAttributes.getElements().get(6);
            bf1.valueProperty().set(true);
        }


        Form chordAttributes = FormBuilder.buildChordAttributesForm();
        if (!values[7].equals("null")) {
            SingleSelectionField sf6 = (SingleSelectionField) chordAttributes.getElements().get(0);
            sf6.selectionProperty().set(values[7]);
        }
        if (!values[8].equals("null")) {
            SingleSelectionField sf7 = (SingleSelectionField) chordAttributes.getElements().get(1);
            sf7.selectionProperty().set(values[8]);
        }
        if (values[9].equals("true")) {
            BooleanField bf2 = (BooleanField) chordAttributes.getElements().get(2);
            bf2.valueProperty().set(true);
        }
        if (!values[10].equals("null")) {
            SingleSelectionField sf8 = (SingleSelectionField) chordAttributes.getElements().get(3);
            sf8.selectionProperty().set(values[10]);
        }
        if (!values[11].equals("null")) {
            SingleSelectionField sf9 = (SingleSelectionField) chordAttributes.getElements().get(4);
            sf9.selectionProperty().set(values[11]);
        }
        if (!values[12].equals("null")) {
            SingleSelectionField sf10 = (SingleSelectionField) chordAttributes.getElements().get(5);
            sf10.selectionProperty().set(values[12]);
        }
        if (values[13].equals("true")) {
            BooleanField bf3 = (BooleanField) chordAttributes.getElements().get(6);
            bf3.valueProperty().set(true);
        }
        if (values[14].equals("true")) {
            BooleanField bf4 = (BooleanField) chordAttributes.getElements().get(7);
            bf4.valueProperty().set(true);
        }
        if (!values[15].equals("null")) {
            SingleSelectionField sf11 = (SingleSelectionField) chordAttributes.getElements().get(8);
            sf11.selectionProperty().set(values[15]);
        }
        if (values[16].equals("true")) {
            BooleanField bf5 = (BooleanField) chordAttributes.getElements().get(9);
            bf5.valueProperty().set(true);
        }
        if (!values[17].equals("null")) {
            SingleSelectionField sf12 = (SingleSelectionField) chordAttributes.getElements().get(10);
            sf12.selectionProperty().set(values[17]);
        }
        if (!values[18].equals("null")) {
            SingleSelectionField sf13 = (SingleSelectionField) chordAttributes.getElements().get(11);
            sf13.selectionProperty().set(values[18]);
        }
        if (!values[19].equals("null")) {
            SingleSelectionField sf14 = (SingleSelectionField) chordAttributes.getElements().get(12);
            sf14.selectionProperty().set(values[19]);
        }


        Form toplineAttributes = FormBuilder.buildToplineAttributesForm();

        for (int i = 0; i < 8; i++) {
            if (!values[20 + i].equals("null")) {
                SingleSelectionField temp = (SingleSelectionField) toplineAttributes.getElements().get(i);
                temp.selectionProperty().set(values[20 + i]);
            }
        }

        Form lyricAttributes = FormBuilder.buildLyricAttributesForm(values[28]);

        if (!values[29].equals("null")) {
            SingleSelectionField sf15 = (SingleSelectionField) lyricAttributes.getElements().get(1);
            sf15.selectionProperty().set(values[29]);
        }

        if (!values[30].equals("null")) {
            SingleSelectionField sf16 = (SingleSelectionField) lyricAttributes.getElements().get(2);
            String str = values[30];

            str = str.substring(0, str.length() - 1);
            sf16.selectionProperty().setValue(str);
        }

        reloadedFormParts[0] = songAttributes;
        reloadedFormParts[1] = chordAttributes;
        reloadedFormParts[2] = toplineAttributes;
        reloadedFormParts[3] = lyricAttributes;

        return reloadedFormParts;

    }
}
