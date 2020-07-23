package classifier;

public class UnclassifiedTupleBuilder {



    public static DataTuple getUnclassifiedTuple() {
        String[] tupleData = new String[30];
        tupleData = populateTestTupleData();
        DataTuple newTuple = new DataTuple(tupleData);
        return newTuple;
    }



    public static String[] populateTestTupleData() {
        String data = "'\'(12-23]\'',>130,pop,mf-duet,DMAJ,TRUE,DMAJ,3,FALSE,no,TRUE,4,'\'(5-6]\'',1,3,triad-notes,4,3,mixed-harm,none,'\'(7-14]\'','\'(1.75-2.61]\'','\'(-inf-187]\'','\'(7-9]\'','\'(-inf-2]\'','\'(2-5]\'','\'(8-11]\'',lover,no";
        String data2 = "'\\'(-inf-12]\\'',80-95,pop,male,DMAJ,TRUE,DMAJ,3,FALSE,no,FALSE,3,'\\'(5-6]\\'',3,2,thirds,1,1,roots,rockbeat-var,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(249-286.5]\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(11-13]\\'','\\'(8-11]\\'',lover,no";

        String cleanString = data.replaceAll("['(+\\]^:\\\\]", "");
        String customTuple = "12-23," +
                "111-120," +
                "edm," +
                "mf-duet," +
                "AMAJ," +
                "FALSE," +
                "AMAJ," +
                "1," +
                "FALSE," +
                "yes," +
                "TRUE," +
                "4," +
                "4-5," +
                "1," +
                "2," +
                "triad-notes," +
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
