package classifier;

import java.util.Arrays;

public class TupleBuilder {



    public static DataTuple getUnclassifiedHitTuple() {
        String[] tupleData = new String[30];
        tupleData = populateTestTupleData();
        DataTuple newTuple = new DataTuple(tupleData);
        return newTuple;
    }

    public static DataTuple getUnclassifiedMissTuple() {
        String[] tupleData = new String[35];
        String data2 = "'\\'(-inf-12]\\'',80-95,pop,male,DMAJ,I-iii-IV-I,TRUE,DMAJ,I-iii-IV-I,3,FALSE,no,IV-I-IV-V,FALSE,IV-I-IV-V,3,'\\'(5-6]\\'',3-3-3-1,3,2,thirds,1-1-1-1,1,1,roots,rockbeat-var,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(249-286.5]\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(11-13]\\'','\\'(8-11]\\'',lover,no";
        String cleanString = data2.replaceAll("['(+\\]^:\\\\]", "");
        String[] splitARFFValues = cleanString.split(",");
        DataTuple newTuple = new DataTuple(splitARFFValues);
        return newTuple;
    }

    public static DataTuple getClassifiedTuple() {
        String[] tupleData;
        tupleData = populateTestTupleData();
        tupleData = Arrays.copyOf(tupleData,35);
        tupleData[34] = "HIT";
        DataTuple newTuple = new DataTuple(true,tupleData);
        return newTuple;
    }

    public static String[] populateTestTupleData() {
      //  String data = "'\'(12-23]\'',>130,pop,mf-duet,DMAJ,TRUE,DMAJ,3,FALSE,no,TRUE,4,'\'(5-6]\'',1,3,triad-notes,4,3,mixed-harm,none,'\'(7-14]\'','\'(1.75-2.61]\'','\'(-inf-187]\'','\'(7-9]\'','\'(-inf-2]\'','\'(2-5]\'','\'(8-11]\'',lover,no";

     //   String cleanString = data.replaceAll("['(+\\]^:\\\\]", "");
        String customTuple = "12-23," +
                "111-120," +
                "edm," +
                "mf-duet," +
                "AMAJ," +
                "VI-VI-i-III," +
                "FALSE," +
                "AMAJ," +
                "IV-IV-vi-I," +
                "1," +
                "FALSE," +
                "yes," +
                "I-V-vi-IV," +
                "TRUE," +
                "I-V-vi-IV," +
                "4," +
                "4-5," +
                "1-3-3-5," +
                "1," +
                "2," +
                "triad-notes," +
                "1-3-1-3," +
                "1," +
                "4," +
                "roots," +
                "moneybeat," +
                "35-41," +
                "1.75-2.61," +
                "372.5-405.5," +
                "14-18," +
                "4-5," +
                "37-49," +
                "16-19," +
                "sage," +
                "yes";
        String[] splitARFFValues = customTuple.split(",");
        return splitARFFValues;
    }
}
