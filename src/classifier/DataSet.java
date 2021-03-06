package classifier;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DataSet {

    /**
     * Tuples stored in List - index can serve as ID. DataTuple object consists of a 'name' String value and a Map of Enum values.
     */

    private String hardCodedDataSet;
    private List<DataTuple> tuples;

    public DataSet(){
        tuples = new ArrayList<DataTuple>();
        hardCodedDataSet = getHardCodeData();
   //     buildDataSet();
    }

    public List<DataTuple> getTuples() {
        return tuples;
    }

    public void addTuple(DataTuple tuple) {
        tuples.add(tuple);
    }

    public double dataSetSize() {
        return tuples.size();
    }

    public String printOutDataSet() {
        String dataSet = "DATASET:\n";
        for (int i = 0; i < tuples.size(); i++) {
            DataTuple dt = tuples.get(i);
            dataSet +=  dt.printTuple() + " \n";
        }
        return dataSet;
    }

    public void buildDataSet() {

        ImportARFFDataset iad = null;
        try {
            iad = new ImportARFFDataset();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String[]> allTuples = iad.getTuples();
        for (int i = 0; i < allTuples.size(); i++) {
            addTuple(new DataTuple(true,allTuples.get(i)));
        }
    }

    public void safeDataSet(){

        List<String[]> allTheTuples = new ArrayList<>();
        String cleanString = hardCodedDataSet.replaceAll("['()+\\]^:\\\\]", "");

        String lines[] = cleanString.split("\\r?\\n");
        for (int i = 0; i < lines.length ; i++) {
            String[] splitARFFValues = lines[i].split(",");
            allTheTuples.add(splitARFFValues);
        }
        for (int i = 0; i < allTheTuples.size(); i++) {
            addTuple(new DataTuple(true,allTheTuples.get(i)));
        }

    }

//    public void createDummyDataSet() {
//        addTuple(new DataTuple("Blurred Lines",
//                INTRO_LEN.Between10and21Secs,
//                No_Songwriters.three,
//                ColabWithStar.yes,
//                HitSongwriter.yes,
//                Hit_targetClass.yes));
//
//        addTuple(new DataTuple("For The Rest Of My Life",
//                INTRO_LEN.Over21Secs,
//                No_Songwriters.two,
//                ColabWithStar.no,
//                HitSongwriter.no,
//                Hit_targetClass.no));
//
//        addTuple(new DataTuple("Nothing Compares 2 U",
//                INTRO_LEN.Under11Secs,
//                No_Songwriters.one,
//                ColabWithStar.no,
//                HitSongwriter.yes,
//                Hit_targetClass.yes));
//
//        addTuple(new DataTuple("The Emperors New Clothes",
//                INTRO_LEN.Between10and21Secs,
//                No_Songwriters.one,
//                ColabWithStar.no,
//                HitSongwriter.no,
//                Hit_targetClass.no));
//
//        addTuple(new DataTuple("Ice Ice Baby",
//                INTRO_LEN.Between10and21Secs,
//                No_Songwriters.fourOrMore,
//                ColabWithStar.no,
//                HitSongwriter.yes,
//                Hit_targetClass.yes));
//
//        addTuple(new DataTuple("I Love You",
//                INTRO_LEN.Over21Secs,
//                No_Songwriters.two,
//                ColabWithStar.no,
//                HitSongwriter.no,
//                Hit_targetClass.no));
//
//        addTuple(new DataTuple("Bitter Sweet Symphony",
//                INTRO_LEN.Between10and21Secs,
//                No_Songwriters.three,
//                ColabWithStar.no,
//                HitSongwriter.yes,
//                Hit_targetClass.yes));
//
//        addTuple(new DataTuple("The Drugs Don't Work",
//                INTRO_LEN.Over21Secs,
//                No_Songwriters.one,
//                ColabWithStar.no,
//                HitSongwriter.no,
//                Hit_targetClass.no));
//
//        addTuple(new DataTuple("Tainted Love",
//                INTRO_LEN.Under11Secs,
//                No_Songwriters.one,
//                ColabWithStar.no,
//                HitSongwriter.yes,
//                Hit_targetClass.yes));
//
//        addTuple(new DataTuple("Bedsitter",
//                INTRO_LEN.Between10and21Secs,
//                No_Songwriters.two,
//                ColabWithStar.no,
//                HitSongwriter.no,
//                Hit_targetClass.no));
//
//        addTuple(new DataTuple("I Touch Myself",
//                INTRO_LEN.Under11Secs,
//                No_Songwriters.fourOrMore,
//                ColabWithStar.no,
//                HitSongwriter.yes,
//                Hit_targetClass.yes));
//
//        addTuple(new DataTuple("Love School",
//                INTRO_LEN.Between10and21Secs,
//                No_Songwriters.two,
//                ColabWithStar.no,
//                HitSongwriter.no,
//                Hit_targetClass.no));
//
//        addTuple(new DataTuple("Mickey",
//                INTRO_LEN.Under11Secs,
//                No_Songwriters.two,
//                ColabWithStar.no,
//                HitSongwriter.yes,
//                Hit_targetClass.yes));
//
//        addTuple(new DataTuple("Nobody",
//                INTRO_LEN.Between10and21Secs,
//                No_Songwriters.one,
//                ColabWithStar.no,
//                HitSongwriter.no,
//                Hit_targetClass.no));
//    }

    public String getHardCodeData(){
        String data = "'\\'(12-23]\\'',>130,pop,mf-duet,DMAJ,I-iii-IV-I,TRUE,DMAJ,I-iii-IV-I,3,FALSE,no,i-VI-III-VII,TRUE,vi-IV-I-V,4,'\\'(5-6]\\'',1-5-3-5,1,3,triad-notes,4-6-1-1,4,3,mixed-harm,none,'\\'(7-14]\\'','\\'(1.75-2.61]\\'','\\'(-inf-187]\\'','\\'(7-9]\\'','\\'(-inf-2]\\'','\\'(2-5]\\'','\\'(8-11]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,pop,male,DMAJ,I-iii-IV-I,TRUE,DMAJ,I-iii-IV-I,3,FALSE,no,IV-I-IV-V,FALSE,IV-I-IV-V,3,'\\'(5-6]\\'',3-3-3-1,3,2,thirds,1-1-1-1,1,1,roots,rockbeat-var,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(249-286.5]\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(11-13]\\'','\\'(8-11]\\'',lover,no,miss\n" +
                "'\\'(23-35]\\'',80-95,pop,male,AMAJ,ii-V-I-IV,FALSE,AMAJ,ii-V-I-IV,4,FALSE,no,I-V-vi-IV,TRUE,I-V-vi-IV,4,'\\'(7-8]\\'',3-5-3-3,3,2,thirds,1-1-1-1,1,1,roots,rockbeat-var,'\\'(7-14]\\'','\\'(-inf--1.72]\\'','\\'(-inf-187]\\'','\\'(14-18]\\'','\\'(5-6]\\'','\\'(10-11]\\'','\\'(8-11]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',121-130,pop,male,Am,i-III-VI-VII,TRUE,CMAJ,vi-I-IV-V,4,FALSE,no,vi-vi-VI-VII,FALSE,vi-vi-VI-VII,3,'\\'(6-7]\\'',2-5-4-1,2,4,mixed-harm,3-1-7-5,3,4,four-note-chord,dancebeat,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(-inf-187]\\'','\\'(14-18]\\'','\\'(3-4]\\'','\\'(22-26]\\'','\\'(-inf-8]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',80-95,edm,female,Ebm,i-VI-III-VII,TRUE,F#MAJ,vi-IV-I-V,4,TRUE,no,i-VI-III-VII,TRUE,vi-IV-I-V,4,'\\'(4-5]\\'',3-7-3-3,3,2,thirds,5-2-3-6,5,4,mixed-harm,dancebeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(-inf-187]\\'','\\'(11-14]\\'','\\'(3-4]\\'','\\'(2-5]\\'','\\'(8-11]\\'',vulnerable,no,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,edm,female,Em,i-i-VI-VI,TRUE,GMAJ,vi-vi-IV-IV,2,FALSE,no,ii-V-I-VI,FALSE,ii-V-I-VI,4,'\\'(5-6]\\'',3-1-5-1,3,3,triad-notes,3-3-3-3,3,1,thirds,dancebeat,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(-inf-187]\\'','\\'(7-9]\\'','\\'(3-4]\\'','\\'(5-7]\\'','\\'(8-11]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',121-130,disco,female,Cm,i-iv-i-V,TRUE,EbMAJ,vi-ii-vi-III,3,TRUE,no,i-iv-i-V,TRUE,vi-ii-vi-III,3,'\\'(3-4]\\'',3-1-1-4,3,3,mixed-harm,3-5-1-4,3,4,mixed-harm,moneybeat,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(212.5-249]\\'','\\'(18-inf)\\'','\\'(5-6]\\'','\\'(9-10]\\'','\\'(-inf-8]\\'',innuendist,yes,HIT\n" +
                "'\\'(35-inf)\\'',111-120,soul,female,FMAJ,NTP,TRUE,FMAJ,NTP,>4,FALSE,yes,I-I-IV-IV,TRUE,I-I-IV-IV,2,'\\'(11-inf)\\'',5-5-5-3,5,2,fifths,7-7-5-3,7,3,triad-notes,latinbeat,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(-inf-187]\\'','\\'(-inf-3]\\'','\\'(2-3]\\'','\\'(5-7]\\'','\\'(13-16]\\'',lover,yes,miss\n" +
                "'\\'(-inf-12]\\'',>130,edm,female,Am,i-v-VI-VII,TRUE,CMAJ,vi-iii-IV-V,4,TRUE,no,i-v-VI-VII,TRUE,vi-iii-IV-V,4,'\\'(8-11]\\'',1-5-5-5,1,2,fifths,1-5-5-5,1,2,fifths,dancebeat,'\\'(35-41]\\'','\\'(-0.85-0.01]\\'','\\'(405.5-inf)\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(49-inf)\\'','\\'(11-13]\\'',innocent,no,HIT\n" +
                "'\\'(12-23]\\'',>130,edm,mf-duet,Bm,i-i-VI-VII,TRUE,DMAJ,vi-vi-IV-V,3,FALSE,no,i-iv-VII-III,TRUE,vi-ii-V-I,4,'\\'(8-11]\\'',1-1-3-1,1,2,roots,5-2-5-5,5,2,fifths,dancebeat,'\\'(28-35]\\'','\\'(-0.85-0.01]\\'','\\'(328.5-372.5]\\'','\\'(5-7]\\'','\\'(7-8]\\'','\\'(13-17]\\'','\\'(31-inf)\\'',lover,no,miss\n" +
                "'\\'(35-inf)\\'',<80,electro-indie,male,Ebm,i-VII-III-VII,TRUE,F#MAJ,vi-V-I-V,3,TRUE,no,i-VII-III-VII,TRUE,vi-V-I-V,3,'\\'(4-5]\\'',3-4-1-1,3,3,pedal,3-4-1-1,3,3,pedal,hiphopbeat,'\\'(21-28]\\'','\\'(-inf--1.72]\\'','\\'(-inf-187]\\'','\\'(18-inf)\\'','\\'(5-6]\\'','\\'(26-37]\\'','\\'(-inf-8]\\'',vulnerable,no,HIT\n" +
                "'\\'(12-23]\\'',>130,indie-rock,male,Dm,i-VII-VI-v,TRUE,FMAJ,vi-V-IV-iii,4,FALSE,no,I-IV-vi-V,TRUE,I-IV-vi-V,4,'\\'(5-6]\\'',3-4-5-6,3,4,pedal,3-5-5-5,3,2,fifths,rockbeat-var,'\\'(41-51)\\'','\\'(-0.85-0.01]\\'','\\'(372.5-405.5]\\'','\\'(18-inf)\\'','\\'(8-inf)\\'','\\'(49-inf)\\'','\\'(16-19]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,country,male,AMAJ,I-I-V-V,TRUE,AMAJ,I-I-V-V,2,TRUE,no,I-I-V-V,TRUE,I-I-V-V,2,'\\'(-inf-3]\\'',3-1-5-3,3,3,triad-notes,3-1-5-3,3,3,triad-notes,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(7-9]\\'','\\'(5-6]\\'','\\'(20-22]\\'','\\'(13-16]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',111-120,country,male,GMAJ,I-IV-I-IV,TRUE,GMAJ,I-IV-I-IV,2,FALSE,no,V-IV-V-vi,FALSE,V-IV-V-vi,3,'\\'(8-11]\\'',5-1-5-5,5,2,fifths,1-3-1-1,1,2,roots,rockbeat-var,'\\'(21-28]\\'','\\'(-1.72--0.85]\\'','\\'(328.5-372.5]\\'','\\'(14-18]\\'','\\'(5-6]\\'','\\'(5-7]\\'','\\'(16-19]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',80-95,pop,female,Fm,i-iv-i-iv,TRUE,AbMAJ,vi-ii-vi-ii,2,TRUE,no,i-iv-i-iv,TRUE,vi-ii-vi-ii,2,'\\'(-inf-3]\\'',1-1-5-5,1,2,triad-notes,1-1-5-5,1,2,triad-notes,hiphopbeat,'\\'(35-41]\\'','\\'(-0.85-0.01]\\'','\\'(405.5-inf)\\'','\\'(5-7]\\'','\\'(7-8]\\'','\\'(26-37]\\'','\\'(31-inf)\\'',sage,yes,HIT\n" +
                "'\\'(23-35]\\'',<80,r&b,female,Fm,i-iv-VII-III,TRUE,AbMAJ,vi-ii-V-I,4,TRUE,no,i-iv-VII-III,TRUE,vi-ii-V-I,4,'\\'(11-inf)\\'',1-4-4-5,1,3,mixed-harm,3-7-4-3,3,3,mixed-harm,slowjam,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(212.5-249]\\'','\\'(7-9]\\'','\\'(4-5]\\'','\\'(10-11]\\'','\\'(13-16]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',<80,pop-rock,male,DbMAJ,I-IV-I-IV,TRUE,DbMAJ,I-IV-I-IV,2,FALSE,no,I-IV-ii-V,TRUE,I-IV-ii-V,4,'\\'(6-7]\\'',3-1-5-1,3,3,triad-notes,1-4-7-5,1,4,mixed-harm,rockbeat-var,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(187-212.5]\\'','\\'(5-7]\\'','\\'(5-6]\\'','\\'(5-7]\\'','\\'(13-16]\\'',lover,yes,HIT\n" +
                "'\\'(12-23]\\'',95-110,rock,male,Ebm,i-i-v-v,TRUE,F#MAJ,vi-vi-III-III,2,FALSE,no,iv-v-VI-v,FALSE,ii-iii-IV-iii,3,'\\'(4-5]\\'',1-1-1-1,1,1,roots,5-4-3-4,5,3,pedal,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(7-9]\\'','\\'(4-5]\\'','\\'(11-13]\\'','\\'(11-13]\\'',lover,yes,miss\n" +
                "'\\'(-inf-12]\\'',111-120,pop,male,DbMAJ,I-V-IV-IV,TRUE,DbMAJ,I-V-IV-IV,3,FALSE,no,i-VII-VI-VI,TRUE,vi-V-IV-IV,3,'\\'(4-5]\\'',6-1-3-3,6,3,mixed-harm,5-4-5-5,5,2,fifths,none,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(8-inf)\\'','\\'(22-26]\\'','\\'(13-16]\\'',lover,yes,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,pop,male,Dm,VII-i-VI-VI,FALSE,FMAJ,V-vi-IV-IV,3,FALSE,no,VII-i-VI-VI,FALSE,V-vi-IV-VI,4,'\\'(3-4]\\'',3-3-3-3,3,1,thirds,4-5-7-3,4,4,mixed-harm,dancebeat,'\\'(21-28]\\'','\\'(-0.85-0.01]\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(6-7]\\'','\\'(17-20]\\'','\\'(16-19]\\'',lover,no,miss\n" +
                "'\\'(23-35]\\'',95-110,disco,male,DMAJ,I-ii-I-ii,TRUE,DMAJ,I-ii-I-ii,2,FALSE,no,I-I-ii-ii,TRUE,I-I-ii-ii,2,'\\'(4-5]\\'',3-7-3-7,3,2,mixed-harm,3-7-3-7,3,2,mixed-harm,dancebeat,'\\'(7-14]\\'','\\'(2.61-3.47]\\'','\\'(212.5-249]\\'','\\'(5-7]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(19-23]\\'',sage,no,HIT\n" +
                "'\\'(12-23]\\'',95-110,disco,male,Bm,i-iv-i-iv,TRUE,DMAJ,vi-ii-vi-ii,2,FALSE,no,i-i-VII-VII,TRUE,vi-vi-V-V,2,'\\'(6-7]\\'',5-5-5-5,5,1,fifths,5-5-5-5,5,1,fifths,dancebeat,'\\'(7-14]\\'','\\'(-1.72--0.85]\\'','\\'(212.5-249]\\'','\\'(7-9]\\'','\\'(6-7]\\'','\\'(20-22]\\'','\\'(19-23]\\'',sage,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop-rock,mf-duet,DMAJ,ii-ii-vi-V,FALSE,DMAJ,ii-ii-vi-V,3,FALSE,no,I-IV-I-V,TRUE,I-IV-I-V,3,'\\'(5-6]\\'',3-3-5-5,3,2,triad-notes,1-5-1-5,1,2,pedal-triad,rockbeat-var,'\\'(51-inf)\\'','\\'(0.88-1.75]\\'','\\'(405.5-inf)\\'','\\'(-inf-3]\\'','\\'(2-3]\\'','\\'(11-13]\\'','\\'(8-11]\\'',hero,no,HIT\n" +
                "'\\'(23-35]\\'',121-130,pop,female,BMAJ,V-IV-V-IV,FALSE,BMAJ,V-IV-V-IV,2,TRUE,no,V-IV-V-IV,FALSE,V-IV-V-IV,2,'\\'(7-8]\\'',1-1-1-4,1,2,pedal,3-3-1-6,3,3,mixed-harm,dancebeat,'\\'(-inf-7]\\'','\\'(0.88-1.75]\\'','\\'(-inf-187]\\'','\\'(-inf-3]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(-inf-8]\\'',political,no,miss\n" +
                "'\\'(12-23]\\'',<80,pop,male,EbMAJ,I-IV-V-V,TRUE,EbMAJ,I-IV-V-V,3,FALSE,no,I-IV-ii-V,TRUE,I-IV-ii-V,4,'\\'(8-11]\\'',5-5-3-3,5,2,triad-notes,1-5-7-5,1,3,four-note-chord,rockbeat-var,'\\'(21-28]\\'','\\'(-0.85-0.01]\\'','\\'(372.5-405.5]\\'','\\'(14-18]\\'','\\'(6-7]\\'','\\'(22-26]\\'','\\'(19-23]\\'',sage,no,HIT\n" +
                "'\\'(-inf-12]\\'',<80,pop,male,CMAJ,I-V-vi-vi,TRUE,CMAJ,I-V-vi-vi,3,FALSE,no,I-V-vi-IV,TRUE,I-V-vi-IV,4,'\\'(7-8]\\'',3-6-5-5,3,3,pedal,5-1-5-3,5,3,triad-notes,rockbeat-var,'\\'(21-28]\\'','\\'(-0.85-0.01]\\'','\\'(372.5-405.5]\\'','\\'(-inf-3]\\'','\\'(8-inf)\\'','\\'(37-49]\\'','\\'(16-19]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',80-95,pop,male,Cm,i-v-VI-III,TRUE,EbMAJ,vi-iii-IV-I,4,FALSE,no,VI-III-i-VII,FALSE,IV-I-vi-V,4,'\\'(5-6]\\'',5-1-7-1,5,3,pedal-four,7-3-5-5,7,3,pedal-four,hiphopbeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(7-9]\\'','\\'(6-7]\\'','\\'(9-10]\\'','\\'(23-31]\\'',lover,yes,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,pop,male,Cm,iv-v-i-i,FALSE,EbMAJ,ii-iii-vi-vi,3,FALSE,no,i-VI-III-VII,TRUE,vi-IV-I-V,4,'\\'(6-7]\\'',5-4-1-7,5,4,pedal,5-5-3-5,5,2,triad-notes,slowjam,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(286.5-328.5]\\'','\\'(3-5]\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(23-31]\\'',lover,yes,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop-rock,female,FMAJ,V-vi-IV-V,FALSE,FMAJ,V-vi-IV-V,3,FALSE,no,IV-V-I-I,FALSE,IV-V-I-I,3,'\\'(8-11]\\'',3-3-3-1,3,2,thirds,5-4-1-1,5,3,pedal,rockbeat-var,'\\'(21-28]\\'','\\'(0.88-1.75]\\'','\\'(328.5-372.5]\\'','\\'(18-inf)\\'','\\'(4-5]\\'','\\'(17-20]\\'','\\'(11-13]\\'',innuendist,yes,HIT\n" +
                "'\\'(12-23]\\'',95-110,rock,female,Bbm,NTP,TRUE,DbMAJ,NTP,>4,TRUE,no,NTP,TRUE,NTP,>4,'\\'(11-inf)\\'',3-5-3-1,3,3,triad-notes,3-4-5-1,3,4,mixed-harm,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(212.5-249]\\'','\\'(3-5]\\'','\\'(3-4]\\'','\\'(9-10]\\'','\\'(19-23]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop-rock,male,DMAJ,I-I-IV-V,TRUE,DMAJ,I-I-IV-V,3,FALSE,no,I-I-V-IV,TRUE,I-I-V-IV,3,'\\'(3-4]\\'',3-3-3-5,3,2,thirds,5-5-3-3,5,2,triad-notes,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(5-7]\\'','\\'(2-3]\\'','\\'(2-5]\\'','\\'(-inf-8]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',121-130,indie-rock,male,Am,i-i-III-III,TRUE,CMAJ,vi-vi-I-I,2,FALSE,no,VII-i-VII-i,FALSE,V-vi-V-vi,3,'\\'(4-5]\\'',1-2-5-3,1,4,mixed-harm,3-2-3-7,3,3,pedal,rockbeat-var,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(212.5-249]\\'','\\'(-inf-3]\\'','\\'(2-3]\\'','\\'(2-5]\\'','\\'(13-16]\\'',lover,no,miss\n" +
                "'\\'(23-35]\\'',95-110,pop,male,CMAJ,I-iii-IV-I,TRUE,CMAJ,I-iii-IV-I,3,FALSE,no,I-V-ii-IV,TRUE,I-V-ii-IV,4,'\\'(7-8]\\'',1-3-3-5,1,3,triad-notes,1-3-1-5,1,3,triad-notes,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(14-18]\\'','\\'(3-4]\\'','\\'(9-10]\\'','\\'(23-31]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',>130,pop,male,GMAJ,ii-V-I-I,FALSE,GMAJ,ii-V-I-I,3,FALSE,no,ii-ii-iii-I,FALSE,ii-ii-iii-I,3,'\\'(4-5]\\'',7-4-1-1,7,3,mixed-harm,1-1-1-1,1,1,roots,rockbeat-var,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(-inf-187]\\'','\\'(-inf-3]\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(-inf-8]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',>130,edm,female,Bm,i-VI-VII-i,TRUE,DMAJ,vi-IV-V-vi,3,FALSE,no,i-VI-III-VII,TRUE,vi-IV-I-V,4,'\\'(4-5]\\'',5-7-5-3,5,3,triad-notes,3-5-3-5,3,2,triad-notes,dancebeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(11-14]\\'','\\'(3-4]\\'','\\'(13-17]\\'','\\'(11-13]\\'',sage,yes,HIT\n" +
                "'\\'(12-23]\\'',>130,pop,female,Bm,i-VII-i-i,TRUE,DMAJ,vi-V-vi-vi,2,FALSE,no,i-VII-iv-VII,TRUE,vi-V-ii-V,3,'\\'(11-inf)\\'',1-3-1-1,1,2,roots,5-5-2-5,5,2,fifths,none,'\\'(-inf-7]\\'','\\'(-0.85-0.01]\\'','\\'(-inf-187]\\'','\\'(3-5]\\'','\\'(5-6]\\'','\\'(9-10]\\'','\\'(13-16]\\'',innocent,no,miss\n" +
                "'\\'(12-23]\\'',121-130,edm,male,Dm,i-i-i-i,TRUE,FMAJ,vi-vi-vi-vi,1,TRUE,no,i-i-i-i,TRUE,vi-vi-vi-vi,4,'\\'(-inf-3]\\'',5-5-5-1,5,2,fifths,5-4-5-1,5,3,mixed-harm,dancebeat,'\\'(28-35]\\'','\\'(-0.85-0.01]\\'','\\'(-inf-187]\\'','\\'(5-7]\\'','\\'(-inf-2]\\'','\\'(5-7]\\'','\\'(13-16]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',121-130,edm,male,FMAJ,NTP,TRUE,FMAJ,NTP,3,FALSE,no,VI-VII-i-i,FALSE,IV-V-vi-vi,3,'\\'(5-6]\\'',1-1-1-1,1,1,roots,2-7-5-5,2,3,mixed-harm,dancebeat,'\\'(-inf-7]\\'','\\'(-0.85-0.01]\\'','\\'(-inf-187]\\'','\\'(3-5]\\'','\\'(3-4]\\'','\\'(5-7]\\'','\\'(11-13]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',111-120,pop,male,Em,i-v-iv-VI,TRUE,GMAJ,vi-iii-ii-IV,4,TRUE,no,i-v-iv-VI,TRUE,vi-iii-ii-IV,4,'\\'(4-5]\\'',5-5-1-3,5,3,triad-notes,7-7-5-5,7,2,four-note-chord,dancebeat,'\\'(35-41]\\'','\\'(0.01-0.88]\\'','\\'(405.5-inf)\\'','\\'(9-11]\\'','\\'(6-7]\\'','\\'(17-20]\\'','\\'(31-inf)\\'',lover,yes,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,pop,male,Em,VI-VII-i-III,FALSE,GMAJ,IV-V-vi-I,4,TRUE,no,VI-VII-i-III,FALSE,IV-V-vi-I,4,'\\'(4-5]\\'',6-6-4-1,6,3,mixed-harm,2-6-5-3,2,4,mixed-harm,dancebeat,'\\'(41-51)\\'','\\'(-0.85-0.01]\\'','\\'(372.5-405.5]\\'','\\'(11-14]\\'','\\'(5-6]\\'','\\'(20-22]\\'','\\'(23-31]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',<80,pop,female,Cm,i-IV-VI-i,TRUE,EbMAJ,vi-II-IV-vi,3,TRUE,no,i-IV-VI-i,TRUE,vi-II-IV-vi,3,'\\'(3-4]\\'',3-1-5-3,3,3,pedal-triad,1-1-3-1,1,2,roots,hiphopbeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(405.5-inf)\\'','\\'(7-9]\\'','\\'(4-5]\\'','\\'(13-17]\\'','\\'(31-inf)\\'',sage,yes,HIT\n" +
                "'\\'(12-23]\\'',<80,pop,female,AbMAJ,V-I-I-V,FALSE,AbMAJ,V-I-I-V,2,FALSE,no,V-IV-I-IV,FALSE,V-IV-I-IV,3,'\\'(-inf-3]\\'',3-4-3-5,3,3,mixed-harm,1-6-3-3,1,3,mixed-harm,hiphopbeat,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(405.5-inf)\\'','\\'(14-18]\\'','\\'(8-inf)\\'','\\'(37-49]\\'','\\'(31-inf)\\'',lover,yes,miss\n" +
                "'\\'(23-35]\\'',121-130,soul,female,GMAJ,I-I-V-IV,TRUE,GMAJ,I-I-V-IV,3,FALSE,no,I-IV-I-V,TRUE,I-IV-I-V,3,'\\'(3-4]\\'',1-1-3-3,1,2,triad-notes,6-6-5-6,6,2,mixed-harm,rockbeat-var,'\\'(28-35]\\'','\\'(-0.85-0.01]\\'','\\'(286.5-328.5]\\'','\\'(14-18]\\'','\\'(2-3]\\'','\\'(17-20]\\'','\\'(19-23]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,soul,female,BbMAJ,I-iii-IV-VI,TRUE,BbMAJ,I-iii-IV-VI,4,FALSE,yes,IV-i-VI-VII,FALSE,II-vi-IV-V,4,'\\'(11-inf)\\'',1-1-5-3,1,3,triad-notes,1-1-3-5,1,3,triad-notes,rockbeat-var,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(4-5]\\'','\\'(17-20]\\'','\\'(19-23]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',111-120,folk-rock,male,Am,i-VI-III-VII,TRUE,CMAJ,vi-IV-I-V,4,TRUE,no,i-VI-III-VII,TRUE,vi-IV-I-V,4,'\\'(4-5]\\'',1-3-2-5,1,4,mixed-harm,3-5-1-5,3,3,pedal-triad,rockbeat-var,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(14-18]\\'','\\'(4-5]\\'','\\'(22-26]\\'','\\'(16-19]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',95-110,pop,male,GMAJ,I-I-vi-IV,TRUE,GMAJ,I-I-vi-IV,3,TRUE,no,I-I-vi-IV,TRUE,I-I-vi-IV,3,'\\'(4-5]\\'',5-5-7-6,5,3,pedal,1-1-4-5,1,3,mixed-harm,rockbeat-var,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(187-212.5]\\'','\\'(3-5]\\'','\\'(3-4]\\'','\\'(2-5]\\'','\\'(31-inf)\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',111-120,pop,mf-duet,Em,I-VI-v-v,TRUE,GMAJ,vi-IV-iii-iii,3,TRUE,no,I-VI-v-v,TRUE,vi-IV-iii-iii,3,'\\'(3-4]\\'',2-3-7-5,2,4,mixed-harm,5-7-7-2,5,3,pedal,dancebeat,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(372.5-405.5]\\'','\\'(14-18]\\'','\\'(7-8]\\'','\\'(20-22]\\'','\\'(31-inf)\\'',lover,yes,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,soul,female,BMAJ,I-ii-iii-ii,TRUE,BMAJ,I-ii-iii-ii,3,TRUE,no,I-ii-iii-ii,TRUE,I-ii-iii-ii,3,'\\'(4-5]\\'',3-7-6-2,3,4,mixed-harm,5-5-3-5,5,2,fifths,hiphopbeat,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(372.5-405.5]\\'','\\'(-inf-3]\\'','\\'(6-7]\\'','\\'(26-37]\\'','\\'(23-31]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',121-130,indie-rock,male,EbMAJ,ii-IV-I-V,FALSE,EbMAJ,ii-IV-I-V,4,TRUE,no,ii-IV-I-V,FALSE,ii-IV-I-V,4,'\\'(4-5]\\'',5-3-5-1,5,3,triad-notes,7-5-1-5,7,3,four-note-chord,rockbeat-var,'\\'(21-28]\\'','\\'(0.88-1.75]\\'','\\'(372.5-405.5]\\'','\\'(14-18]\\'','\\'(5-6]\\'','\\'(9-10]\\'','\\'(23-31]\\'',political,no,HIT\n" +
                "'\\'(23-35]\\'',121-130,electro-indie,male,Fm,i-VII-VI-III,TRUE,AbMAJ,vi-V-IV-I,4,TRUE,no,i-VII-VI-III,TRUE,vi-V-IV-I,4,'\\'(4-5]\\'',2-1-2-3,2,3,mixed-harm,4-6-2-3,4,4,mixed-harm,moneybeat,'\\'(14-21]\\'','\\'(0.88-1.75]\\'','\\'(328.5-372.5]\\'','\\'(-inf-3]\\'','\\'(3-4]\\'','\\'(22-26]\\'','\\'(16-19]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',111-120,soul,male,Cm,i-III-VI-V,TRUE,EbMAJ,vi-I-IV-III,4,TRUE,no,i-III-VI-V,TRUE,vi-I-IV-III,4,'\\'(5-6]\\'',1-3-3-1,1,2,triad-notes,1-3-3-1,1,2,triad-notes,moneybeat,'\\'(-inf-7]\\'','\\'(0.01-0.88]\\'','\\'(187-212.5]\\'','\\'(9-11]\\'','\\'(6-7]\\'','\\'(5-7]\\'','\\'(11-13]\\'',vulnerable,yes,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,soul,male,Bbm,I-i-VII-VII,TRUE,DbMAJ,VI-vi-V-V,3,FALSE,yes,iv-v-II-ii,FALSE,ii-iii-VII-vii,4,'\\'(11-inf)\\'',5-5-4-4,5,2,pedal,1-5-7-1,1,3,mixed-harm,motownbeat,'\\'(-inf-7]\\'','\\'(-0.85-0.01]\\'','\\'(212.5-249]\\'','\\'(-inf-3]\\'','\\'(7-8]\\'','\\'(11-13]\\'','\\'(13-16]\\'',sage,yes,miss\n" +
                "'\\'(-inf-12]\\'',80-95,pop,mf-duet,F#m,i-VII-v-VI,TRUE,AMAJ,vi-V-iii-IV,4,TRUE,no,i-VII-v-VI,TRUE,vi-V-iii-IV,4,'\\'(4-5]\\'',3-5-7-6,3,4,pedal,4-5-7-5,4,3,pedal,slowjam,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(405.5-inf)\\'','\\'(7-9]\\'','\\'(8-inf)\\'','\\'(26-37]\\'','\\'(31-inf)\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',<80,pop,male,DMAJ,I-iii-vi-vi,TRUE,DMAJ,I-iii-vi-vi,3,TRUE,no,I-iii-vi-vi,TRUE,I-iii-vi-vi,3,'\\'(5-6]\\'',5-3-5-5,5,2,triad-notes,1-1-5-5,1,2,pedal-triad,hiphopbeat,'\\'(14-21]\\'','\\'(0.88-1.75]\\'','\\'(372.5-405.5]\\'','\\'(18-inf)\\'','\\'(7-8]\\'','\\'(49-inf)\\'','\\'(23-31]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',121-130,pop,mf-duet,Dm,i-VII-i-VII,TRUE,FMAJ,vi-V-vi-V,2,FALSE,no,i-VII-VI-VII,TRUE,vi-V-IV-V,3,'\\'(3-4]\\'',5-5-7-5,5,2,fifths,3-4-1-6,3,4,mixed-harm,latinbeat,'\\'(7-14]\\'','\\'(1.75-2.61]\\'','\\'(328.5-372.5]\\'','\\'(5-7]\\'','\\'(2-3]\\'','\\'(2-5]\\'','\\'(13-16]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',121-130,soul,male,AMAJ,NTP,FALSE,AMAJ,NTP,>4,FALSE,yes,V-IV-I-V,FALSE,V-IV-I-V,3,'\\'(8-11]\\'',3-3-5-1,3,3,triad-notes,3-5-2-1,3,4,mixed-harm,motownbeat,'\\'(-inf-7]\\'','\\'(1.75-2.61]\\'','\\'(187-212.5]\\'','\\'(5-7]\\'','\\'(3-4]\\'','\\'(11-13]\\'','\\'(13-16]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',80-95,soul,mf-duet,Gm,i-iv-V-iv,TRUE,BbMAJ,vi-ii-III-ii,3,FALSE,no,I-vi-IV-V,TRUE,I-vi-IV-V,4,'\\'(11-inf)\\'',5-1-1-1,5,2,roots,1-3-5-5,1,3,pedal-triad,slowjam,'\\'(7-14]\\'','\\'(-1.72--0.85]\\'','\\'(328.5-372.5]\\'','\\'(9-11]\\'','\\'(6-7]\\'','\\'(17-20]\\'','\\'(23-31]\\'',lover,yes,HIT\n" +
                "'\\'(12-23]\\'',<80,soul,female,Am,i-v-i-v,TRUE,CMAJ,vi-III-vi-III,2,TRUE,no,i-v-i-v,TRUE,vi-III-vi-III,2,'\\'(4-5]\\'',3-6-3-6,3,2,pedal,7-7-4-1,7,3,mixed-harm,hiphopbeat,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(-inf-3]\\'','\\'(6-7]\\'','\\'(20-22]\\'','\\'(16-19]\\'',sage,yes,miss\n" +
                "'\\'(12-23]\\'',95-110,r&b,male,Bm,iv-VII-VII-i,FALSE,DMAJ,ii-V-V-vi,3,FALSE,no,I-iii-vi-V,TRUE,I-iii-vi-V,4,'\\'(8-11]\\'',2-5-3-5,2,3,mixed-harm,3-1-1-7,3,3,four-note-chord,rockbeat-var,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(286.5-328.5]\\'','\\'(3-5]\\'','\\'(8-inf)\\'','\\'(22-26]\\'','\\'(8-11]\\'',lover,no,HIT\n" +
                "'\\'(23-35]\\'',80-95,r&b,male,EbMAJ,I-V-IV-IV,TRUE,EbMAJ,I-V-IV-IV,3,FALSE,no,I-iii-IV-V,TRUE,I-iii-IV-V,4,'\\'(6-7]\\'',1-3-5-5,1,3,triad-notes,3-1-7-4,3,4,pedal,rockbeat-var,'\\'(-inf-7]\\'','\\'(1.75-2.61]\\'','\\'(405.5-inf)\\'','\\'(18-inf)\\'','\\'(8-inf)\\'','\\'(37-49]\\'','\\'(-inf-8]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',80-95,pop-rock,male,EMAJ,I-I-vi-vi,TRUE,EMAJ,I-I-vi-vi,2,FALSE,no,I-vi-IV-V,TRUE,I-vi-IV-V,4,'\\'(5-6]\\'',1-5-1-5,1,2,triad-notes,1-3-5-3,1,3,pedal-triad,moneybeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(212.5-249]\\'','\\'(7-9]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(16-19]\\'',lover,no,HIT\n" +
                "'\\'(23-35]\\'',>130,rock,male,Em,i-VII-IV-VI,TRUE,GMAJ,vi-V-II-IV,4,TRUE,yes,i-VII-iv-VI,TRUE,vi-V-ii-IV,4,'\\'(5-6]\\'',1-5-6-6,1,3,mixed-harm,5-5-5-5,5,1,fifths,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(11-14]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(11-13]\\'',hero,no,miss\n" +
                "'\\'(23-35]\\'',80-95,pop,male,EbMAJ,I-V-vi-IV,TRUE,EbMAJ,I-V-vi-IV,4,FALSE,no,IV-V-I-I,FALSE,IV-V-I-I,3,'\\'(5-6]\\'',3-1-3-2,3,3,pedal,5-6-3-1,5,4,pedal,hiphopbeat,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(187-212.5]\\'','\\'(9-11]\\'','\\'(4-5]\\'','\\'(5-7]\\'','\\'(11-13]\\'',lover,yes,HIT\n" +
                "'\\'(12-23]\\'',80-95,folk-rock,male,BbMAJ,NTP,TRUE,BbMAJ,NTP,>4,FALSE,yes,VI-VII-i-VI,FALSE,IV-V-vi-IV,4,'\\'(6-7]\\'',3-1-5-5,3,3,triad-notes,5-3-3-5,5,2,pedal-triad,rockbeat-var,'\\'(7-14]\\'','\\'(1.75-2.61]\\'','\\'(-inf-187]\\'','\\'(3-5]\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(16-19]\\'',innocent,yes,miss\n" +
                "'\\'(-inf-12]\\'',>130,pop-rock,male,DMAJ,I-V-IV-I,TRUE,DMAJ,I-V-IV-I,3,TRUE,no,I-V-IV-I,TRUE,I-V-IV-I,3,'\\'(3-4]\\'',1-3-1-5,1,3,triad-notes,1-3-5-1,1,3,triad-notes,moneybeat,'\\'(14-21]\\'','\\'(1.75-2.61]\\'','\\'(212.5-249]\\'','\\'(3-5]\\'','\\'(4-5]\\'','\\'(13-17]\\'','\\'(16-19]\\'',sage,no,HIT\n" +
                "'\\'(-inf-12]\\'',>130,rock,male,FMAJ,I-vi-I-vi,TRUE,FMAJ,I-vi-I-vi,2,FALSE,no,VI-VII-i-i,FALSE,IV-V-vi-vi,3,'\\'(5-6]\\'',5-2-5-2,5,2,mixed-harm,5-1-7-3,5,4,four-note-chord,rockbeat-var,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(3-4]\\'','\\'(49-inf)\\'','\\'(-inf-8]\\'',innocent,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,edm,female,Fm,i-i-VII-VII,TRUE,AbMAJ,vi-vi-V-V,2,TRUE,no,i-i-VII-VII,TRUE,vi-vi-V-V,2,'\\'(8-11]\\'',2-7-1-5,2,4,mixed-harm,2-7-3-3,2,3,mixed-harm,dancebeat,'\\'(-inf-7]\\'','\\'(0.01-0.88]\\'','\\'(-inf-187]\\'','\\'(-inf-3]\\'','\\'(6-7]\\'','\\'(9-10]\\'','\\'(8-11]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',111-120,edm,male,DMAJ,ii-I-V-V,FALSE,DMAJ,ii-I-V-V,3,TRUE,no,ii-I-V-V,FALSE,ii-I-V-V,3,'\\'(3-4]\\'',6-7-3-1,6,4,pedal,4-5-1-1,4,3,pedal,dancebeat,'\\'(35-41]\\'','\\'(0.01-0.88]\\'','\\'(187-212.5]\\'','\\'(5-7]\\'','\\'(3-4]\\'','\\'(5-7]\\'','\\'(11-13]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',121-130,pop,female,Ebm,i-IV-VI-i,TRUE,F#MAJ,vi-II-IV-vi,3,FALSE,no,I-ii-IV-I,TRUE,I-ii-IV-I,3,'\\'(5-6]\\'',5-1-7-3,5,4,pedal-four,5-5-6-1,5,3,mixed-harm,dancebeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(212.5-249]\\'','\\'(11-14]\\'','\\'(4-5]\\'','\\'(26-37]\\'','\\'(13-16]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',121-130,pop,female,Gm,VI-i-VII-iv,FALSE,BbMAJ,IV-vi-V-ii,4,FALSE,no,IV-I-V-ii,FALSE,IV-I-V-ii,4,'\\'(6-7]\\'',3-5-1-7,3,4,four-note-chord,5-1-1-5,5,2,triad-notes,hiphopbeat,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(-inf-187]\\'','\\'(5-7]\\'','\\'(2-3]\\'','\\'(11-13]\\'','\\'(19-23]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',95-110,country,female,C#m,VI-VI-i-i,FALSE,EMAJ,IV-IV-vi-vi,2,FALSE,no,I-I-iii-iii,TRUE,I-I-iii-iii,2,'\\'(5-6]\\'',2-2-5-5,2,2,mixed-harm,3-3-5-5,3,2,triad-notes,rockbeat-var,'\\'(-inf-7]\\'','\\'(1.75-2.61]\\'','\\'(212.5-249]\\'','\\'(11-14]\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(13-16]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',80-95,country,female,DbMAJ,I-vi-IV-I,TRUE,DbMAJ,I-vi-IV-I,3,FALSE,no,IV-vi-IV-V,FALSE,IV-vi-IV-V,3,'\\'(6-7]\\'',3-5-7-5,3,3,pedal-four,2-5-2-5,2,2,mixed-harm,hiphopbeat,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(187-212.5]\\'','\\'(7-9]\\'','\\'(6-7]\\'','\\'(11-13]\\'','\\'(13-16]\\'',innocent,yes,miss\n" +
                "'\\'(12-23]\\'',121-130,pop,female,CMAJ,I-I-I-I,TRUE,CMAJ,I-I-I-I,1,TRUE,no,I-I-I-I,TRUE,I-I-I-I,1,'\\'(4-5]\\'',1-3-5-1,1,3,triad-notes,5-5-1-1,5,2,triad-notes,dancebeat,'\\'(35-41]\\'','\\'(0.01-0.88]\\'','\\'(187-212.5]\\'','\\'(14-18]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(-inf-8]\\'',explorer,no,HIT\n" +
                "'\\'(35-inf)\\'',>130,disco,female,Dm,i-i-i-i,TRUE,FMAJ,vi-vi-vi-vi,1,FALSE,no,iv-V-iv-V,FALSE,ii-III-ii-III,2,'\\'(3-4]\\'',1-7-5-5,1,3,mixed-harm,1-1-1-1,1,1,pedal-triad,dancebeat,'\\'(21-28]\\'','\\'(1.75-2.61]\\'','\\'(-inf-187]\\'','\\'(14-18]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(11-13]\\'',sage,no,miss\n" +
                "'\\'(12-23]\\'',>130,pop,male,EbMAJ,ii-ii-I-I,FALSE,EbMAJ,ii-ii-I-I,2,TRUE,no,ii-ii-I-I,FALSE,ii-ii-I-I,2,'\\'(-inf-3]\\'',5-4-5-1,5,3,mixed-harm,4-6-5-5,4,3,mixed-harm,latinbeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(372.5-405.5]\\'','\\'(3-5]\\'','\\'(5-6]\\'','\\'(9-10]\\'','\\'(31-inf)\\'',partier,yes,HIT\n" +
                "'\\'(-inf-12]\\'',>130,pop,male,CMAJ,V-IV-V-IV,FALSE,CMAJ,V-IV-V-IV,2,TRUE,no,V-IV-V-IV,FALSE,V-IV-V-IV,2,'\\'(-inf-3]\\'',3-2-3-2,3,2,pedal,1-1-1-1,1,1,pedal-triad,hiphopbeat,'\\'(21-28]\\'','\\'(2.61-3.47]\\'','\\'(328.5-372.5]\\'','\\'(11-14]\\'','\\'(5-6]\\'','\\'(17-20]\\'','\\'(31-inf)\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,edm,male,Fm,VI-VI-i-III,FALSE,AbMAJ,IV-IV-vi-I,3,TRUE,no,VI-VI-i-III,FALSE,IV-IV-vi-I,3,'\\'(3-4]\\'',7-7-5-3,7,3,pedal,7-7-5-1,7,3,pedal,dancebeat,'\\'(21-28]\\'','\\'(0.88-1.75]\\'','\\'(372.5-405.5]\\'','\\'(14-18]\\'','\\'(4-5]\\'','\\'(26-37]\\'','\\'(19-23]\\'',innuendist,no,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,edm,female,F#m,i-VI-III-III,TRUE,AMAJ,vi-IV-I-I,3,TRUE,no,i-VI-III-III,TRUE,vi-IV-I-I,3,'\\'(3-4]\\'',1-6-1-6,1,2,pedal,5-6-3-2,5,4,mixed-harm,dancebeat,'\\'(28-35]\\'','\\'(-inf--1.72]\\'','\\'(286.5-328.5]\\'','\\'(11-14]\\'','\\'(8-inf)\\'','\\'(37-49]\\'','\\'(23-31]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',<80,pop,male,Gm,i-III-VI-VII,TRUE,BbMAJ,vi-I-IV-V,4,TRUE,no,i-III-VI-VII,TRUE,vi-I-IV-V,4,'\\'(5-6]\\'',3-1-5-4,3,4,pedal,1-1-5-5,1,2,triad-notes,rockbeat-var,'\\'(7-14]\\'','\\'(1.75-2.61]\\'','\\'(405.5-inf)\\'','\\'(5-7]\\'','\\'(3-4]\\'','\\'(9-10]\\'','\\'(23-31]\\'',explorer,no,HIT\n" +
                "'\\'(12-23]\\'',80-95,pop,male,FMAJ,ii-V-I-vi,FALSE,FMAJ,ii-V-I-vi,4,TRUE,no,ii-V-I-vi,FALSE,ii-V-I-vi,4,'\\'(6-7]\\'',2-5-3-5,2,3,mixed-harm,1-6-1-1,1,2,roots,dancebeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(9-11]\\'','\\'(2-3]\\'','\\'(2-5]\\'','\\'(19-23]\\'',tribute,no,miss\n" +
                "'\\'(12-23]\\'',80-95,folk,male,CMAJ,I-IV-I-IV,TRUE,CMAJ,I-IV-I-IV,2,FALSE,no,vi-V-I-I,FALSE,vi-V-I-I,3,'\\'(4-5]\\'',5-1-5-1,5,2,triad-notes,1-1-1-3,1,2,roots,folkpercussion,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(187-212.5]\\'','\\'(14-18]\\'','\\'(4-5]\\'','\\'(17-20]\\'','\\'(8-11]\\'',lover,no,HIT\n" +
                "'\\'(23-35]\\'',111-120,folk,male,Am,i-III-i-III,TRUE,CMAJ,vi-I-vi-I,2,FALSE,no,VI-III-VII-i,FALSE,IV-I-V-vi,4,'\\'(4-5]\\'',5-1-5-1,5,2,triad-notes,3-3-1-5,3,3,triad-notes,folkpercussion,'\\'(7-14]\\'','\\'(-1.72--0.85]\\'','\\'(212.5-249]\\'','\\'(-inf-3]\\'','\\'(5-6]\\'','\\'(20-22]\\'','\\'(19-23]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,pop,female,BbMAJ,I-IV-vi-V,TRUE,BbMAJ,I-IV-vi-V,4,TRUE,no,I-IV-vi-V,TRUE,I-IV-vi-V,4,'\\'(4-5]\\'',1-5-3-5,1,3,pedal-triad,1-2-3-1,1,3,pedal,hiphopbeat,'\\'(28-35]\\'','\\'(-0.85-0.01]\\'','\\'(372.5-405.5]\\'','\\'(11-14]\\'','\\'(4-5]\\'','\\'(20-22]\\'','\\'(31-inf)\\'',hero,no,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,pop,female,EMAJ,vi-IV-IV-I,FALSE,EMAJ,vi-IV-IV-I,3,TRUE,no,vi-IV-IV-I,FALSE,vi-IV-IV-I,3,'\\'(5-6]\\'',1-2-3-6,1,4,pedal,5-3-3-1,5,3,triad-notes,dancebeat,'\\'(14-21]\\'','\\'(2.61-3.47]\\'','\\'(286.5-328.5]\\'','\\'(9-11]\\'','\\'(8-inf)\\'','\\'(22-26]\\'','\\'(19-23]\\'',lover,yes,miss\n" +
                "'\\'(-inf-12]\\'',<80,pop,male,DbMAJ,IV-V-I-vi,FALSE,DbMAJ,IV-V-I-vi,4,TRUE,no,IV-V-I-vi,FALSE,IV-V-I-vi,4,'\\'(4-5]\\'',4-1-6-1,4,3,pedal,2-4-5-5,2,3,pedal,hiphopbeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(372.5-405.5]\\'','\\'(11-14]\\'','\\'(8-inf)\\'','\\'(26-37]\\'','\\'(19-23]\\'',hero,yes,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,pop-rock,male,Bbm,i-III-VII-VI,TRUE,DbMAJ,vi-I-V-IV,4,FALSE,no,ii-IV-I-V,FALSE,ii-IV-I-V,4,'\\'(5-6]\\'',3-5-5-5,3,2,fifths,7-5-5-1,7,3,four-note-chord,dancebeat,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(328.5-372.5]\\'','\\'(9-11]\\'','\\'(7-8]\\'','\\'(13-17]\\'','\\'(16-19]\\'',lover,yes,miss\n" +
                "'\\'(-inf-12]\\'',111-120,edm,female,AMAJ,IV-I-vi-V,FALSE,AMAJ,IV-I-vi-V,4,FALSE,no,IV-iv-I-V,FALSE,IV-iv-I-V,4,'\\'(4-5]\\'',2-1-7-5,2,4,mixed-harm,5-3-5-1,5,3,triad-notes,dancebeat,'\\'(14-21]\\'','\\'(-1.72--0.85]\\'','\\'(187-212.5]\\'','\\'(-inf-3]\\'','\\'(7-8]\\'','\\'(37-49]\\'','\\'(16-19]\\'',partier,no,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,edm,male,Bm,VI-VI-i-VII,FALSE,DMAJ,IV-IV-vi-V,3,FALSE,no,VI-i-VII-VII,FALSE,IV-vi-V-V,3,'\\'(3-4]\\'',2-2-7-5,2,3,mixed-harm,1-5-5-5,1,2,fifths,hiphopbeat,'\\'(14-21]\\'','\\'(-1.72--0.85]\\'','\\'(249-286.5]\\'','\\'(11-14]\\'','\\'(6-7]\\'','\\'(20-22]\\'','\\'(11-13]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',95-110,pop-rock,female,AMAJ,I-V-IV-IV,TRUE,AMAJ,I-V-IV-IV,3,FALSE,no,I-V-ii-IV,TRUE,I-V-ii-IV,4,'\\'(5-6]\\'',1-4-3-6,1,4,mixed-harm,6-2-1-3,6,4,mixed-harm,hiphopbeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(3-5]\\'','\\'(2-3]\\'','\\'(2-5]\\'','\\'(19-23]\\'',hero,no,HIT\n" +
                "'\\'(12-23]\\'',80-95,rock,female,AMAJ,I-I-I-I,TRUE,AMAJ,I-I-I-I,1,FALSE,no,NTP,FALSE,NTP,3,'\\'(5-6]\\'',1-1-1-1,1,1,roots,5-3-5-5,5,2,triad-notes,hiphopbeat,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(249-286.5]\\'','\\'(18-inf)\\'','\\'(4-5]\\'','\\'(5-7]\\'','\\'(19-23]\\'',innocent,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop,female,DMAJ,IV-V-I-IV,FALSE,DMAJ,IV-V-I-IV,3,TRUE,no,IV-V-I-IV,FALSE,IV-V-I-IV,3,'\\'(3-4]\\'',6-2-6-3,6,3,mixed-harm,3-5-1-5,3,3,triad-notes,dancebeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(11-14]\\'','\\'(8-inf)\\'','\\'(20-22]\\'','\\'(8-11]\\'',innuendist,yes,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,pop,female,AbMAJ,I-IV-IV-V,TRUE,AbMAJ,I-IV-IV-V,3,TRUE,no,I-IV-IV-V,TRUE,I-IV-IV-V,3,'\\'(3-4]\\'',2-5-4-5,2,3,mixed-harm,3-2-6-4,3,4,mixed-harm,dancebeat,'\\'(21-28]\\'','\\'(-0.85-0.01]\\'','\\'(328.5-372.5]\\'','\\'(11-14]\\'','\\'(5-6]\\'','\\'(20-22]\\'','\\'(19-23]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',111-120,pop,m-duet,Cm,i-VI-iv-VII,TRUE,EbMAJ,vi-IV-ii-V,4,TRUE,no,i-VI-iv-VII,TRUE,vi-IV-ii-V,4,'\\'(4-5]\\'',1-7-4-5,1,4,mixed-harm,5-7-2-4,5,4,mixed-harm,latinbeat,'\\'(28-35]\\'','\\'(-1.72--0.85]\\'','\\'(405.5-inf)\\'','\\'(11-14]\\'','\\'(7-8]\\'','\\'(37-49]\\'','\\'(8-11]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,pop,m-duet,GMAJ,vi-V-IV-I,FALSE,GMAJ,vi-V-IV-I,4,TRUE,no,vi-V-IV-I,FALSE,vi-V-IV-I,4,'\\'(4-5]\\'',7-5-7-3,7,3,four-note-chord,3-5-5-5,3,2,pedal-triad,dancebeat,'\\'(35-41]\\'','\\'(-0.85-0.01]\\'','\\'(372.5-405.5]\\'','\\'(11-14]\\'','\\'(5-6]\\'','\\'(49-inf)\\'','\\'(8-11]\\'',lover,no,miss\n" +
                "'\\'(23-35]\\'',<80,folk-rock,male,Em,i-VI-VII-v,TRUE,GMAJ,vi-IV-V-iii,4,FALSE,no,IV-I-V-vi,FALSE,IV-I-V-vi,4,'\\'(5-6]\\'',5-5-5-5,5,1,fifths,5-1-5-3,5,3,pedal-triad,rockbeat-var,'\\'(28-35]\\'','\\'(0.01-0.88]\\'','\\'(372.5-405.5]\\'','\\'(14-18]\\'','\\'(6-7]\\'','\\'(26-37]\\'','\\'(31-inf)\\'',sage,no,HIT\n" +
                "'\\'(12-23]\\'',>130,folk,male,EMAJ,vi-V-I-I,FALSE,EMAJ,vi-V-I-I,3,FALSE,no,ii-IV-I-V,FALSE,ii-IV-I-V,4,'\\'(5-6]\\'',1-1-3-3,1,2,triad-notes,1-5-3-5,1,3,triad-notes,none,'\\'(-inf-7]\\'','\\'(2.61-3.47]\\'','\\'(372.5-405.5]\\'','\\'(18-inf)\\'','\\'(6-7]\\'','\\'(10-11]\\'','\\'(13-16]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',<80,indie-rock,male,C#m,i-III-iv-i,TRUE,EMAJ,vi-I-ii-vi,3,TRUE,no,i-III-iv-i,TRUE,vi-I-ii-vi,3,'\\'(4-5]\\'',5-2-1-3,5,4,mixed-harm,1-5-2-1,1,3,mixed-harm,rockbeat-var,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(328.5-372.5]\\'','\\'(7-9]\\'','\\'(8-inf)\\'','\\'(13-17]\\'','\\'(16-19]\\'',hero,yes,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,indie-rock,male,C#m,i-VII-iv-i,TRUE,EMAJ,vi-V-ii-vi,3,TRUE,no,i-VII-iv-i,TRUE,vi-V-ii-vi,3,'\\'(5-6]\\'',1-5-1-1,1,2,roots,4-5-1-1,4,3,pedal,dancebeat,'\\'(35-41]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(5-7]\\'','\\'(6-7]\\'','\\'(37-49]\\'','\\'(23-31]\\'',innocent,yes,miss\n" +
                "'\\'(-inf-12]\\'',80-95,pop,female,Em,i-VI-III-VII,TRUE,GMAJ,vi-IV-I-V,4,FALSE,no,I-V-vi-IV,TRUE,I-V-vi-IV,4,'\\'(5-6]\\'',7-2-5-1,7,4,pedal,1-5-5-1,1,2,triad-notes,hiphopbeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(5-7]\\'','\\'(6-7]\\'','\\'(11-13]\\'','\\'(31-inf)\\'',hero,yes,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,pop,female,AMAJ,IV-V-I-I,FALSE,AMAJ,IV-V-I-I,3,FALSE,no,I-vi-IV-V,TRUE,I-vi-IV-V,4,'\\'(6-7]\\'',5-4-5-1,5,3,mixed-harm,1-3-1-3,1,2,triad-notes,hiphopbeat,'\\'(35-41]\\'','\\'(0.01-0.88]\\'','\\'(405.5-inf)\\'','\\'(14-18]\\'','\\'(6-7]\\'','\\'(17-20]\\'','\\'(19-23]\\'',lover,yes,miss\n" +
                "'\\'(-inf-12]\\'',121-130,pop,male,AMAJ,V-V-IV-ii,FALSE,AMAJ,V-V-IV-ii,3,TRUE,no,V-V-IV-ii,FALSE,V-V-IV-ii,3,'\\'(3-4]\\'',5-5-5-5,5,1,fifths,1-1-1-1,1,1,roots,dancebeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(212.5-249]\\'','\\'(7-9]\\'','\\'(2-3]\\'','\\'(10-11]\\'','\\'(-inf-8]\\'',innuendist,no,HIT\n" +
                "'\\'(23-35]\\'',121-130,pop,male,EMAJ,I-I-IV-V,TRUE,EMAJ,I-I-IV-V,3,FALSE,no,ii-V-ii-V,FALSE,ii-V-ii-V,2,'\\'(4-5]\\'',1-1-1-1,1,1,roots,3-5-7-1,3,4,four-note-chord,dancebeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(212.5-249]\\'','\\'(9-11]\\'','\\'(5-6]\\'','\\'(11-13]\\'','\\'(11-13]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',111-120,pop,m-duet,GMAJ,I-I-V-V,TRUE,GMAJ,I-I-V-V,2,TRUE,no,I-I-V-V,TRUE,I-I-V-V,2,'\\'(-inf-3]\\'',3-3-5-5,3,2,triad-notes,1-3-3-5,1,3,triad-notes,dancebeat,'\\'(41-51)\\'','\\'(0.01-0.88]\\'','\\'(405.5-inf)\\'','\\'(3-5]\\'','\\'(7-8]\\'','\\'(49-inf)\\'','\\'(31-inf)\\'',innuendist,yes,HIT\n" +
                "'\\'(23-35]\\'',<80,r&b,male,DMAJ,NTP,FALSE,DMAJ,NTP,4,TRUE,yes,NTP,TRUE,NTP,>4,'\\'(11-inf)\\'',6-4-1-1,6,3,mixed-harm,1-1-6-5,1,3,mixed-harm,slowjam,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(405.5-inf)\\'','\\'(11-14]\\'','\\'(8-inf)\\'','\\'(49-inf)\\'','\\'(11-13]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',111-120,edm,female,Cm,VI-i-iv-VI,FALSE,EbMAJ,IV-vi-ii-IV,3,TRUE,no,VI-i-iv-VI,FALSE,IV-vi-ii-IV,3,'\\'(3-4]\\'',6-5-5-5,6,2,mixed-harm,6-5-5-5,6,2,fifths,dancebeat,'\\'(21-28]\\'','\\'(-inf--1.72]\\'','\\'(-inf-187]\\'','\\'(18-inf)\\'','\\'(-inf-2]\\'','\\'(37-49]\\'','\\'(31-inf)\\'',lover,no,HIT\n" +
                "'\\'(35-inf)\\'',111-120,edm,female,Bm,i-VI-VII-i,TRUE,DMAJ,vi-IV-V-vi,3,TRUE,no,i-VI-VII-i,TRUE,vi-IV-V-vi,3,'\\'(3-4]\\'',1-6-5-4,1,4,pedal,1-7-5-5,1,3,pedal-four,dancebeat,'\\'(28-35]\\'','\\'(-1.72--0.85]\\'','\\'(372.5-405.5]\\'','\\'(9-11]\\'','\\'(4-5]\\'','\\'(10-11]\\'','\\'(13-16]\\'',innuendist,no,miss\n" +
                "'\\'(-inf-12]\\'',<80,pop,female,FMAJ,I-V-vi-I,TRUE,FMAJ,I-V-vi-I,3,FALSE,no,NTP,TRUE,NTP,4,'\\'(8-11]\\'',1-1-7-3,1,3,four-note-chord,5-5-5-5,5,1,fifths,hiphopbeat,'\\'(7-14]\\'','\\'(1.75-2.61]\\'','\\'(187-212.5]\\'','\\'(5-7]\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(8-11]\\'',lover,yes,HIT\n" +
                "'\\'(12-23]\\'',121-130,folk-rock,female,BbMAJ,I-IV-I-IV,TRUE,BbMAJ,I-IV-I-IV,2,TRUE,no,I-IV-I-IV,TRUE,I-IV-I-IV,2,'\\'(-inf-3]\\'',1-1-1-5,1,2,roots,3-5-5-5,3,2,fifths,rockbeat-var,'\\'(-inf-7]\\'','\\'(0.01-0.88]\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(13-16]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop-rock,male,AMAJ,I-V-IV-I,TRUE,AMAJ,I-V-IV-I,3,TRUE,no,I-V-IV-I,TRUE,I-V-IV-I,3,'\\'(3-4]\\'',1-3-3-1,1,2,triad-notes,3-5-5-1,3,3,triad-notes,moneybeat,'\\'(7-14]\\'','\\'(-1.72--0.85]\\'','\\'(187-212.5]\\'','\\'(-inf-3]\\'','\\'(5-6]\\'','\\'(9-10]\\'','\\'(-inf-8]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,rock,male,Gm,i-VII-VI-III,TRUE,BbMAJ,vi-V-IV-I,4,TRUE,no,i-VII-VI-III,TRUE,vi-V-IV-I,4,'\\'(7-8]\\'',5-5-5-1,5,2,fifths,7-4-5-1,7,4,mixed-harm,rockbeat-var,'\\'(21-28]\\'','\\'(0.88-1.75]\\'','\\'(286.5-328.5]\\'','\\'(3-5]\\'','\\'(4-5]\\'','\\'(13-17]\\'','\\'(8-11]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',>130,pop,male,Gm,i-III-VI-iv,TRUE,BbMAJ,vi-I-IV-ii,4,TRUE,no,I-III-VI-iv,TRUE,vi-I-IV-ii,4,'\\'(5-6]\\'',5-6-3-2,5,4,mixed-harm,1-1-1-1,1,1,roots,dancebeat,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(212.5-249]\\'','\\'(14-18]\\'','\\'(7-8]\\'','\\'(26-37]\\'','\\'(11-13]\\'',lover,yes,HIT\n" +
                "'\\'(12-23]\\'',>130,pop,male,Am,i-VII-i-VII,TRUE,CMAJ,vi-V-vi-V,2,FALSE,no,iv-v-III-iv,FALSE,ii-iii-I-ii,3,'\\'(5-6]\\'',1-2-1-2,1,2,pedal,5-5-5-5,5,1,fifths,dancebeat,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(187-212.5]\\'','\\'(-inf-3]\\'','\\'(5-6]\\'','\\'(10-11]\\'','\\'(13-16]\\'',vulnerable,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop,female,Am,i-VII-VI-III,TRUE,CMAJ,vi-V-IV-I,4,TRUE,no,i-VII-VI-III,TRUE,vi-V-IV-I,4,'\\'(4-5]\\'',3-1-5-3,3,3,triad-notes,3-4-1-3,3,3,mixed-harm,latinbeat,'\\'(14-21]\\'','\\'(-1.72--0.85]\\'','\\'(286.5-328.5]\\'','\\'(18-inf)\\'','\\'(4-5]\\'','\\'(26-37]\\'','\\'(8-11]\\'',hero,no,HIT\n" +
                "'\\'(-inf-12]\\'',111-120,edm,female,Bm,iv-VII-i-VII,FALSE,DMAJ,ii-V-vi-V,3,TRUE,no,iv-VII-i-VII,FALSE,ii-V-vi-V,3,'\\'(3-4]\\'',5-6-1-1,5,3,mixed-harm,7-3-3-6,7,3,mixed-harm,dancebeat,'\\'(35-41]\\'','\\'(-0.85-0.01]\\'','\\'(372.5-405.5]\\'','\\'(14-18]\\'','\\'(7-8]\\'','\\'(26-37]\\'','\\'(23-31]\\'',innuendist,yes,miss\n" +
                "'\\'(35-inf)\\'',95-110,rock,male,Cm,i-VI-VII-i,TRUE,EbMAJ,vi-IV-V-vi,3,FALSE,no,iv-iv-i-VII,FALSE,ii-ii-vi-V,3,'\\'(5-6]\\'',5-5-5-3,5,2,fifths,3-3-3-5,3,2,thirds,moneybeat,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(249-286.5]\\'','\\'(9-11]\\'','\\'(2-3]\\'','\\'(2-5]\\'','\\'(-inf-8]\\'',hero,yes,HIT\n" +
                "'\\'(35-inf)\\'',>130,rock,male,Cm,NTP,TRUE,EbMAJ,NTP,4,FALSE,no,i-VII-III-VII,TRUE,vi-V-I-V,3,'\\'(6-7]\\'',5-1-3-6,5,4,mixed-harm,5-6-3-5,5,3,pedal,rockbeat-var,'\\'(-inf-7]\\'','\\'(0.88-1.75]\\'','\\'(-inf-187]\\'','\\'(5-7]\\'','\\'(3-4]\\'','\\'(2-5]\\'','\\'(11-13]\\'',innocent,yes,miss\n" +
                "'\\'(-inf-12]\\'',80-95,pop,f-duet,Fm,i-VII-III-v,TRUE,AbMAJ,vi-V-I-iii,4,FALSE,no,VI-v-i-III,FALSE,IV-iii-vi-I,4,'\\'(5-6]\\'',2-3-1-7,2,4,mixed-harm,5-5-3-1,5,3,triad-notes,rockbeat-var,'\\'(51-inf)\\'','\\'(-inf--1.72]\\'','\\'(405.5-inf)\\'','\\'(18-inf)\\'','\\'(4-5]\\'','\\'(5-7]\\'','\\'(19-23]\\'',lover,yes,HIT\n" +
                "'\\'(23-35]\\'',121-130,edm,f-duet,C#m,VI-v-i-III,FALSE,EMAJ,IV-iii-vi-I,4,TRUE,no,VI-v-i-III,FALSE,IV-iii-vi-I,4,'\\'(4-5]\\'',5-7-3-1,5,4,pedal-four,5-7-3-6,5,4,mixed-harm,dancebeat,'\\'(28-35]\\'','\\'(0.88-1.75]\\'','\\'(286.5-328.5]\\'','\\'(18-inf)\\'','\\'(2-3]\\'','\\'(7-9]\\'','\\'(-inf-8]\\'',hero,yes,miss\n" +
                "'\\'(-inf-12]\\'',111-120,pop-rock,male,DMAJ,I-V-vi-IV,TRUE,DMAJ,I-V-vi-IV,4,TRUE,no,I-V-vi-IV,TRUE,I-V-vi-IV,4,'\\'(5-6]\\'',1-4-3-5,1,4,pedal,1-4-3-5,1,4,pedal,rockbeat-var,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(212.5-249]\\'','\\'(9-11]\\'','\\'(5-6]\\'','\\'(9-10]\\'','\\'(13-16]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',80-95,pop-rock,male,Ebm,i-VII-v-VI,TRUE,F#MAJ,vi-V-iii-IV,4,TRUE,no,i-VII-v-VI,TRUE,vi-V-iii-IV,4,'\\'(5-6]\\'',4-5-6-5,4,3,pedal,2-1-3-5,2,4,mixed-harm,rockbeat-var,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(249-286.5]\\'','\\'(5-7]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(11-13]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,pop-rock,female,BMAJ,I-V-ii-vi,TRUE,BMAJ,I-V-ii-vi,4,FALSE,no,I-IV-V-V,TRUE,I-IV-V-V,3,'\\'(6-7]\\'',3-5-1-3,3,4,triad-notes,1-3-3-5,1,3,triad-notes,dancebeat,'\\'(21-28]\\'','\\'(-1.72--0.85]\\'','\\'(212.5-249]\\'','\\'(7-9]\\'','\\'(4-5]\\'','\\'(5-7]\\'','\\'(16-19]\\'',lover,yes,HIT\n" +
                "'\\'(-inf-12]\\'',>130,pop-rock,female,DMAJ,I-iii-I-iii,TRUE,DMAJ,I-iii-I-iii,2,FALSE,no,I-ii-IV-V,TRUE,I-ii-IV-V,4,'\\'(8-11]\\'',1-5-1-5,1,2,triad-notes,5-7-5-4,5,3,mixed-harm,rockbeat-var,'\\'(7-14]\\'','\\'(2.61-3.47]\\'','\\'(187-212.5]\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(7-9]\\'','\\'(23-31]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',>130,rock,male,Fm,i-i-i-iv,TRUE,AbMAJ,vi-vi-vi-ii,2,FALSE,no,i-III-iv-VI,TRUE,vi-I-ii-IV,4,'\\'(7-8]\\'',7-7-7-5,7,2,sevenths,7-5-5-3,7,3,triad-notes,rockbeat-var,'\\'(14-21]\\'','\\'(1.75-2.61]\\'','\\'(187-212.5]\\'','\\'(9-11]\\'','\\'(3-4]\\'','\\'(7-9]\\'','\\'(19-23]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,rock,male,DMAJ,IV-V-I-I,FALSE,DMAJ,IV-V-I-I,3,FALSE,no,I-V-IV-V,TRUE,I-V-IV-V,3,'\\'(4-5]\\'',1-5-3-3,1,3,triad-notes,3-5-1-5,3,3,triad-notes,rockbeat-var,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(212.5-249]\\'','\\'(11-14]\\'','\\'(4-5]\\'','\\'(7-9]\\'','\\'(16-19]\\'',innuendist,no,miss\n" +
                "'\\'(23-35]\\'',111-120,pop-rock,male,GMAJ,V-IV-V-IV,FALSE,GMAJ,V-IV-V-IV,2,FALSE,no,VI-VII-v-i,FALSE,IV-V-iii-vi,4,'\\'(7-8]\\'',2-3-5-3,2,3,mixed-harm,6-5-3-4,6,4,pedal,rockbeat-var,'\\'(28-35]\\'','\\'(-0.85-0.01]\\'','\\'(328.5-372.5]\\'','\\'(-inf-3]\\'','\\'(8-inf)\\'','\\'(2-5]\\'','\\'(19-23]\\'',sage,yes,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,pop,male,C#m,v-i-VI-VI,FALSE,EMAJ,iii-vi-IV-IV,3,TRUE,no,v-i-VI-VI,FALSE,iii-vi-IV-IV,3,'\\'(6-7]\\'',1-4-5-5,1,3,mixed-harm,7-3-3-5,7,3,four-note-chord,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(9-11]\\'','\\'(5-6]\\'','\\'(10-11]\\'','\\'(11-13]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',>130,pop,male,GMAJ,I-I-vi-vi,TRUE,GMAJ,I-I-vi-vi,2,FALSE,no,NTP,TRUE,NTP,4,'\\'(7-8]\\'',3-3-1-1,3,2,triad-notes,1-1-6-1,1,2,roots,rockbeat-var,'\\'(14-21]\\'','\\'(3.47-inf)\\'','\\'(372.5-405.5]\\'','\\'(18-inf)\\'','\\'(3-4]\\'','\\'(2-5]\\'','\\'(13-16]\\'',innuendist,no,HIT\n" +
                "'\\'(12-23]\\'',>130,rock,male,GMAJ,I-V-vi-V,TRUE,GMAJ,I-V-vi-V,3,TRUE,no,I-V-vi-V,TRUE,I-V-vi-V,3,'\\'(7-8]\\'',3-1-5-1,3,3,triad-notes,1-4-1-1,1,2,roots,rockbeat-var,'\\'(14-21]\\'','\\'(0.88-1.75]\\'','\\'(405.5-inf)\\'','\\'(-inf-3]\\'','\\'(7-8]\\'','\\'(17-20]\\'','\\'(16-19]\\'',innocent,no,miss\n" +
                "'\\'(12-23]\\'',80-95,indie-rock,male,AMAJ,V-ii-I-I,FALSE,AMAJ,V-ii-I-I,3,TRUE,no,V-ii-I-I,FALSE,V-ii-I-I,3,'\\'(3-4]\\'',3-7-4-3,3,3,mixed-harm,5-1-6-6,5,3,pedal,rockbeat-var,'\\'(14-21]\\'','\\'(1.75-2.61]\\'','\\'(372.5-405.5]\\'','\\'(-inf-3]\\'','\\'(6-7]\\'','\\'(11-13]\\'','\\'(19-23]\\'',sage,yes,HIT\n" +
                "'\\'(12-23]\\'',<80,indie-rock,male,CMAJ,I-vi-III-IV,TRUE,CMAJ,I-vi-III-IV,4,FALSE,no,IV-iii-vi-V,FALSE,IV-iii-vi-V,4,'\\'(5-6]\\'',5-5-3-3,5,2,triad-notes,5-3-3-1,5,3,triad-notes,rockbeat-var,'\\'(28-35]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(5-7]\\'','\\'(6-7]\\'','\\'(13-17]\\'','\\'(11-13]\\'',tribute,no,miss\n" +
                "'\\'(12-23]\\'',95-110,pop-rock,male,EMAJ,I-IV-vi-IV,TRUE,EMAJ,I-IV-vi-IV,3,TRUE,no,I-IV-vi-IV,TRUE,I-IV-vi-IV,3,'\\'(5-6]\\'',3-5-3-5,3,2,triad-notes,5-5-5-6,5,2,fifths,rockbeat-var,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(5-7]\\'','\\'(3-4]\\'','\\'(11-13]\\'','\\'(16-19]\\'',sage,no,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,rock,male,AMAJ,V-V-I-I,FALSE,AMAJ,V-V-I-I,2,FALSE,no,IV-I-V-Vi,FALSE,IV-I-V-Vi,4,'\\'(5-6]\\'',7-3-3-3,7,2,triad-notes,3-3-3-3,3,1,thirds,rockbeat-var,'\\'(7-14]\\'','\\'(0.88-1.75]\\'','\\'(-inf-187]\\'','\\'(-inf-3]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(-inf-8]\\'',sage,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop,female,F#m,i-VI-VII-v,TRUE,AMAJ,vi-IV-V-iii,4,TRUE,no,i-VI-VII-v,TRUE,vi-IV-V-iii,4,'\\'(4-5]\\'',1-4-3-5,1,4,mixed-harm,1-3-3-4,1,3,mixed-harm,dancebeat,'\\'(21-28]\\'','\\'(-0.85-0.01]\\'','\\'(405.5-inf)\\'','\\'(-inf-3]\\'','\\'(6-7]\\'','\\'(49-inf)\\'','\\'(19-23]\\'',partier,no,HIT\n" +
                "'\\'(-inf-12]\\'',80-95,pop,female,EMAJ,I-V-I-V,TRUE,EMAJ,I-V-I-V,2,FALSE,no,I-IV-ii-I,TRUE,I-IV-ii-I,3,'\\'(4-5]\\'',3-5-1-6,3,4,mixed-harm,3-5-1-1,3,3,triad-notes,dancebeat,'\\'(21-28]\\'','\\'(-0.85-0.01]\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(6-7]\\'','\\'(20-22]\\'','\\'(16-19]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',>130,pop,female,EMAJ,V-IV-V-V,FALSE,EMAJ,V-IV-V-V,2,FALSE,no,I-V-IV-V,TRUE,I-V-IV-V,3,'\\'(3-4]\\'',1-1-1-1,1,1,roots,5-1-5-5,5,2,fifths,rockbeat-var,'\\'(41-51)\\'','\\'(0.88-1.75]\\'','\\'(405.5-inf)\\'','\\'(18-inf)\\'','\\'(8-inf)\\'','\\'(49-inf)\\'','\\'(31-inf)\\'',lover,yes,HIT\n" +
                "'\\'(12-23]\\'',>130,pop,female,DMAJ,NTP,TRUE,DMAJ,NTP,>4,TRUE,no,NTP,TRUE,NTP,4,'\\'(7-8]\\'',3-5-3-5,3,2,pedal-triad,3-1-2-3,3,3,pedal,rockbeat-var,'\\'(35-41]\\'','\\'(0.88-1.75]\\'','\\'(372.5-405.5]\\'','\\'(18-inf)\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(13-16]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,folk,male,DbMAJ,vi-V-I-I,FALSE,DbMAJ,vi-V-I-I,3,TRUE,no,vi-V-I-I,FALSE,vi-V-I-I,3,'\\'(4-5]\\'',1-1-3-3,1,2,triad-notes,5-6-1-3,5,4,mixed-harm,folkpercussion,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(22-26]\\'','\\'(19-23]\\'',innocent,no,HIT\n" +
                "'\\'(12-23]\\'',95-110,folk,male,GMAJ,vi-IV-I-I,FALSE,GMAJ,vi-IV-I-I,3,TRUE,no,vi-IV-I-I,FALSE,vi-IV-I-I,3,'\\'(4-5]\\'',3-2-5-5,3,3,mixed-harm,3-5-1-1,3,3,triad-notes,folkpercussion,'\\'(7-14]\\'','\\'(-1.72--0.85]\\'','\\'(187-212.5]\\'','\\'(5-7]\\'','\\'(8-inf)\\'','\\'(11-13]\\'','\\'(8-11]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,pop-rock,male,DbMAJ,IV-V-vi-V,FALSE,DbMAJ,IV-V-vi-V,3,FALSE,no,I-IV-vi-V,TRUE,I-IV-vi-V,4,'\\'(6-7]\\'',3-1-3-3,3,2,thirds,1-5-3-5,1,3,pedal-triad,rockbeat-var,'\\'(28-35]\\'','\\'(-1.72--0.85]\\'','\\'(328.5-372.5]\\'','\\'(9-11]\\'','\\'(5-6]\\'','\\'(37-49]\\'','\\'(16-19]\\'',lover,yes,HIT\n" +
                "'\\'(12-23]\\'',95-110,indie-rock,male,FMAJ,I-I-vi-vi,TRUE,FMAJ,I-I-vi-vi,2,FALSE,no,IV-I-V-vi,FALSE,IV-I-V-vi,4,'\\'(4-5]\\'',5-6-7-1,5,4,mixed-harm,2-3-5-3,2,3,mixed-harm,rockbeat-var,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(7-9]\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(16-19]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,edm,female,Gm,i-VII-VI-VII,TRUE,BbMAJ,vi-V-IV-V,3,TRUE,no,i-VII-VI-VII,TRUE,vi-V-IV-V,3,'\\'(4-5]\\'',3-3-5-5,3,2,triad-notes,5-2-7-2,5,3,mixed-harm,dancebeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(187-212.5]\\'','\\'(9-11]\\'','\\'(5-6]\\'','\\'(17-20]\\'','\\'(-inf-8]\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',121-130,edm,male,Em,i-III-iv-V,TRUE,GMAJ,vi-I-ii-III,4,TRUE,no,i-III-iv-V,TRUE,vi-I-ii-III,4,'\\'(4-5]\\'',1-5-5-5,1,2,fifths,2-7-7-7,2,2,sevenths,dancebeat,'\\'(21-28]\\'','\\'(0.01-0.88]\\'','\\'(187-212.5]\\'','\\'(9-11]\\'','\\'(-inf-2]\\'','\\'(9-10]\\'','\\'(8-11]\\'',vulnerable,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop,male,Gm,i-VI-iv-VII,TRUE,BbMAJ,vi-IV-ii-V,4,TRUE,no,i-VI-iv-VII,TRUE,vi-IV-ii-V,4,'\\'(5-6]\\'',3-3-5-3,3,2,thirds,3-5-1-5,3,3,triad-notes,hiphopbeat,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(249-286.5]\\'','\\'(11-14]\\'','\\'(4-5]\\'','\\'(5-7]\\'','\\'(13-16]\\'',lover,yes,HIT\n" +
                "'\\'(23-35]\\'',111-120,pop,male,DMAJ,I-V-I-V,TRUE,DMAJ,I-V-I-V,2,FALSE,yes,V-IV-vi-I,FALSE,V-IV-vi-I,4,'\\'(6-7]\\'',1-6-1-6,1,2,mixed-harm,5-5-1-5,5,3,fifths,rockbeat-var,'\\'(7-14]\\'','\\'(-1.72--0.85]\\'','\\'(187-212.5]\\'','\\'(-inf-3]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(8-11]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',95-110,r&b,m-duet,G#m,i-VII-v-VI,TRUE,BMAJ,vi-V-iii-IV,4,TRUE,no,i-VII-v-VI,TRUE,vi-V-iii-IV,4,'\\'(4-5]\\'',4-3-3-3,4,2,thirds,5-5-7-7,5,2,triad-notes,hiphopbeat,'\\'(21-28]\\'','\\'(0.88-1.75]\\'','\\'(405.5-inf)\\'','\\'(18-inf)\\'','\\'(7-8]\\'','\\'(22-26]\\'','\\'(31-inf)\\'',lover,no,HIT\n" +
                "'\\'(12-23]\\'',95-110,r&b,m-duet,Em,iv-VI-VII-i,FALSE,GMAJ,ii-IV-V-vi,4,TRUE,no,iv-VI-VII-i,FALSE,ii-IV-V-vi,4,'\\'(5-6]\\'',5-2-1-5,5,3,mixed-harm,7-5-1-1,7,3,four-note-chord,hiphopbeat,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(405.5-inf)\\'','\\'(14-18]\\'','\\'(8-inf)\\'','\\'(37-49]\\'','\\'(31-inf)\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,folk,female,CMAJ,I-IV-vi-V,TRUE,CMAJ,I-IV-vi-V,4,TRUE,no,I-IV-vi-V,TRUE,I-IV-vi-V,4,'\\'(6-7]\\'',3-7-5-5,3,3,four-note-chord,3-7-5-5,3,3,four-note-chord,rockbeat-var,'\\'(14-21]\\'','\\'(3.47-inf)\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(3-4]\\'','\\'(49-inf)\\'','\\'(8-11]\\'',innocent,no,HIT\n" +
                "'\\'(12-23]\\'',80-95,electro-indie,female,C#m,i-III-ii-v,TRUE,EMAJ,vi-I-vii-iii,4,TRUE,no,i-III-ii-v,TRUE,vi-I-vii-iii,4,'\\'(8-11]\\'',1-1-1-1,1,1,roots,5-3-3-7,5,3,four-note-chord,hiphopbeat,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(212.5-249]\\'','\\'(3-5]\\'','\\'(2-3]\\'','\\'(7-9]\\'','\\'(16-19]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',95-110,pop,mf-duet,EMAJ,IV-I-V-V,FALSE,EMAJ,IV-I-V-V,3,TRUE,no,IV-I-V-V,FALSE,IV-I-V-V,3,'\\'(3-4]\\'',5-1-1-1,5,2,roots,5-1-6-4,5,4,mixed-harm,hiphopbeat,'\\'(14-21]\\'','\\'(0.88-1.75]\\'','\\'(286.5-328.5]\\'','\\'(18-inf)\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(23-31]\\'',innocent,yes,HIT\n" +
                "'\\'(12-23]\\'',121-130,pop,mf-duet,BbMAJ,I-IV-V-V,TRUE,BbMAJ,I-IV-V-V,3,FALSE,no,I-IV-V-V,TRUE,I-IV-V-V,3,'\\'(3-4]\\'',3-5-4-1,3,4,mixed-harm,3-5-7-7,3,3,four-note-chord,rockbeat-var,'\\'(21-28]\\'','\\'(1.75-2.61]\\'','\\'(405.5-inf)\\'','\\'(18-inf)\\'','\\'(5-6]\\'','\\'(10-11]\\'','\\'(19-23]\\'',hero,no,miss\n" +
                "'\\'(-inf-12]\\'',121-130,pop,mf-duet,Gm,i-III-v-VII,TRUE,BbMAJ,vi-I-iii-V,4,FALSE,no,i-III-v-VII,TRUE,vi-I-iii-V,4,'\\'(4-5]\\'',3-3-1-5,3,3,triad-notes,1-3-5-5,1,3,triad-notes,dancebeat,'\\'(51-inf)\\'','\\'(-inf--1.72]\\'','\\'(286.5-328.5]\\'','\\'(14-18]\\'','\\'(6-7]\\'','\\'(49-inf)\\'','\\'(-inf-8]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,pop,male,BbMAJ,ii-IV-I-V,FALSE,BbMAJ,ii-IV-I-V,4,FALSE,no,ii-IV-I-V,FALSE,ii-IV-I-V,4,'\\'(4-5]\\'',1-3-2-1,1,3,mixed-harm,3-1-3-5,3,3,triad-notes,dancebeat,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(187-212.5]\\'','\\'(18-inf)\\'','\\'(7-8]\\'','\\'(49-inf)\\'','\\'(-inf-8]\\'',lover,no,miss\n" +
                "'\\'(12-23]\\'',<80,pop-rock,male,C#m,i-III-VI-III,TRUE,EMAJ,vi-I-IV-I,3,FALSE,no,I-I-I-I,TRUE,I-I-I-I,1,'\\'(4-5]\\'',1-5-5-3,1,3,triad-notes,5-1-3-1,5,3,triad-notes,rockbeat-var,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(-inf-187]\\'','\\'(9-11]\\'','\\'(-inf-2]\\'','\\'(-inf-2]\\'','\\'(11-13]\\'',explorer,yes,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,folk-rock,male,AMAJ,IV-IV-I-I,FALSE,AMAJ,IV-IV-I-I,3,FALSE,no,IV-IV-I-I,FALSE,IV-IV-I-I,2,'\\'(7-8]\\'',6-5-5-3,6,3,mixed-harm,6-5-3-3,6,3,mixed-harm,rockbeat-var,'\\'(21-28]\\'','\\'(-1.72--0.85]\\'','\\'(249-286.5]\\'','\\'(11-14]\\'','\\'(6-7]\\'','\\'(22-26]\\'','\\'(8-11]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',95-110,pop-rock,male,GMAJ,iii-IV-I-V,FALSE,GMAJ,iii-IV-I-V,4,FALSE,no,IV-I-ii-V,FALSE,IV-I-ii-V,4,'\\'(7-8]\\'',3-5-5-1,3,3,triad-notes,7-1-4-1,7,3,mixed-harm,rockbeat-var,'\\'(21-28]\\'','\\'(0.88-1.75]\\'','\\'(372.5-405.5]\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(22-26]\\'','\\'(23-31]\\'',lover,no,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,pop-rock,male,BMAJ,I-I-vi-VII,TRUE,BMAJ,I-I-vi-VII,3,FALSE,yes,I-V-IV-vi,TRUE,I-V-IV-vi,4,'\\'(7-8]\\'',1-1-3-2,1,3,mixed-harm,5-5-5-3,5,2,fifths,rockbeat-var,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(5-7]\\'','\\'(2-3]\\'','\\'(2-5]\\'','\\'(-inf-8]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',111-120,pop-rock,male,AMAJ,I-I-V-IV,TRUE,AMAJ,I-I-V-IV,2,FALSE,no,I-I-V-IV,TRUE,I-I-V-IV,3,'\\'(8-11]\\'',3-1-4-5,3,4,mixed-harm,5-5-4-5,5,2,fifths,rockbeat-var,'\\'(28-35]\\'','\\'(-1.72--0.85]\\'','\\'(328.5-372.5]\\'','\\'(9-11]\\'','\\'(4-5]\\'','\\'(26-37]\\'','\\'(23-31]\\'',lover,yes,HIT\n" +
                "'\\'(-inf-12]\\'',>130,indie-rock,male,Bm,ii-III-v-VI,FALSE,DMAJ,vii-I-iii-IV,4,FALSE,no,VI-VI-VII-i,FALSE,IV-IV-V-vi,3,'\\'(11-inf)\\'',7-5-7-7,7,2,sevenths,2-5-3-3,2,3,mixed-harm,rockbeat-var,'\\'(7-14]\\'','\\'(-0.85-0.01]\\'','\\'(249-286.5]\\'','\\'(3-5]\\'','\\'(3-4]\\'','\\'(37-49]\\'','\\'(16-19]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',111-120,pop-rock,male,EMAJ,I-IV-V-IV,TRUE,EMAJ,I-IV-V-IV,3,FALSE,no,IV-I-V-vi,FALSE,IV-I-V-vi,4,'\\'(8-11]\\'',3-6-5-5,3,3,pedal,5-1-3-3,5,3,triad-notes,rockbeat-var,'\\'(14-21]\\'','\\'(0.01-0.88]\\'','\\'(328.5-372.5]\\'','\\'(14-18]\\'','\\'(5-6]\\'','\\'(17-20]\\'','\\'(16-19]\\'',innocent,no,HIT\n" +
                "'\\'(-inf-12]\\'',95-110,rock,male,F#MAJ,I-V-vi-IV,TRUE,F#MAJ,I-V-vi-IV,4,FALSE,no,I-V-IV-IV,TRUE,I-V-IV-IV,3,'\\'(11-inf)\\'',5-5-4-5,5,2,fifths,3-5-5-5,3,2,fifths,rockbeat-var,'\\'(7-14]\\'','\\'(1.75-2.61]\\'','\\'(212.5-249]\\'','\\'(5-7]\\'','\\'(4-5]\\'','\\'(9-10]\\'','\\'(23-31]\\'',innocent,no,miss\n" +
                "'\\'(-inf-12]\\'',>130,pop-rock,male,DMAJ,V-V-V-IV,FALSE,DMAJ,V-V-V-IV,4,FALSE,no,I-IV-V-V,TRUE,I-IV-V-V,3,'\\'(7-8]\\'',1-3-1-3,1,2,triad-notes,5-7-5-5,5,2,fifths,rockbeat-var,'\\'(14-21]\\'','\\'(-1.72--0.85]\\'','\\'(249-286.5]\\'','\\'(11-14]\\'','\\'(5-6]\\'','\\'(7-9]\\'','\\'(13-16]\\'',hero,yes,HIT\n" +
                "'\\'(12-23]\\'',>130,rock,male,DMAJ,IV-I-I-V,FALSE,DMAJ,IV-I-I-V,3,FALSE,no,IV-I-vi-I,FALSE,IV-I-vi-I,3,'\\'(8-11]\\'',3-5-5-5,3,2,fifths,5-1-1-1,5,2,roots,rockbeat-var,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(249-286.5]\\'','\\'(11-14]\\'','\\'(4-5]\\'','\\'(20-22]\\'','\\'(-inf-8]\\'',lover,no,miss\n" +
                "'\\'(-inf-12]\\'',80-95,pop,m-duet,AMAJ,I-III-vi-V,TRUE,AMAJ,I-III-vi-V,4,FALSE,yes,IV-VII-i-i,FALSE,IV-VII-i-i,3,'\\'(7-8]\\'',3-5-1-5,3,3,triad-notes,3-1-5-5,3,3,triad-notes,rockbeat-var,'\\'(14-21]\\'','\\'(1.75-2.61]\\'','\\'(405.5-inf)\\'','\\'(7-9]\\'','\\'(8-inf)\\'','\\'(37-49]\\'','\\'(31-inf)\\'',ruler,yes,HIT\n" +
                "'\\'(12-23]\\'',>130,pop,male,Bbm,i-VI-III-V,TRUE,DbMAJ,vi-IV-I-iii,4,FALSE,no,i-VI-iv-VII,TRUE,vi-IV-ii-V,4,'\\'(6-7]\\'',1-3-1-6,1,3,mixed-harm,5-7-2-3,5,4,pedal,rockbeat-var,'\\'(14-21]\\'','\\'(-0.85-0.01]\\'','\\'(286.5-328.5]\\'','\\'(14-18]\\'','\\'(3-4]\\'','\\'(10-11]\\'','\\'(13-16]\\'',lover,yes,miss\n" +
                "'\\'(12-23]\\'',121-130,pop,mf-duet,AbMAJ,I-I-IV-IV,TRUE,AbMAJ,I-I-IV-IV,3,TRUE,no,I-I-IV-IV,TRUE,I-I-IV-IV,2,'\\'(-inf-3]\\'',5-3-1-5,5,3,triad-notes,5-7-1-5,5,3,four-note-chord,dancebeat,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(286.5-328.5]\\'','\\'(9-11]\\'','\\'(5-6]\\'','\\'(20-22]\\'','\\'(23-31]\\'',partier,yes,HIT\n" +
                "'\\'(-inf-12]\\'',121-130,edm,female,Am,iv-VII-i-VII,FALSE,CMAJ,ii-V-vi-V,3,FALSE,no,iv-v-VI-VII,FALSE,ii-iii-IV-V,4,'\\'(7-8]\\'',1-1-1-2,1,2,roots,4-2-6-5,4,4,mixed-harm,dancebeat,'\\'(7-14]\\'','\\'(0.01-0.88]\\'','\\'(-inf-187]\\'','\\'(7-9]\\'','\\'(4-5]\\'','\\'(20-22]\\'','\\'(-inf-8]\\'',innocent,no,miss";
        return data;
    }
}
