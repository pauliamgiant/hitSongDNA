package classifier;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DataSet {

    /**
     * Tuples stored in List - index can serve as ID. DataTuple object consists of a 'name' String value and a Map of Enum values.
     */

    private List<DataTuple> tuples;

    public DataSet() throws FileNotFoundException {
        tuples = new ArrayList<DataTuple>();
        buildDataSet();
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

    public void buildDataSet() throws FileNotFoundException {

        ImportARFFDataset iad = new ImportARFFDataset();
        List<String[]> allTuples = iad.getTuples();
        for (int i = 0; i < allTuples.size(); i++) {
            addTuple(new DataTuple(true,allTuples.get(i)));
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
}
