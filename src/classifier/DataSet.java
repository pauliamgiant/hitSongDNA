package classifier;

import classifier.Attributes.*;

import java.util.ArrayList;
import java.util.List;

public class DataSet {

    /**
     * Tuples stored in List - index can serve as ID. DataTuple object consists of a 'name' String value and a Map of Enum values.
     */

    private List<DataTuple> tuples;

    public DataSet() {
        tuples = new ArrayList<DataTuple>();
        createDummyDataSet();
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
            dataSet += dt.getName() + ": " + dt.printTuple() + " \n";
        }
        return dataSet;
    }

    /**
     * YES 9
     * NO 5
     */
    public void createDummyDataSet() {
        addTuple(new DataTuple("Blurred Lines",
                Intro.Between10and21Secs,
                No_Songwriters.three,
                ColabWithStar.yes,
                HitSongwriter.yes,
                Hit_targetClass.yes));

        addTuple(new DataTuple("For The Rest Of My Life",
                Intro.Over21Secs,
                No_Songwriters.two,
                ColabWithStar.no,
                HitSongwriter.no,
                Hit_targetClass.no));

        addTuple(new DataTuple("Nothing Compares 2 U",
                Intro.Under11Secs,
                No_Songwriters.one,
                ColabWithStar.no,
                HitSongwriter.yes,
                Hit_targetClass.yes));

        addTuple(new DataTuple("The Emperors New Clothes",
                Intro.Between10and21Secs,
                No_Songwriters.one,
                ColabWithStar.no,
                HitSongwriter.no,
                Hit_targetClass.no));

        addTuple(new DataTuple("Ice Ice Baby",
                Intro.Between10and21Secs,
                No_Songwriters.fourOrMore,
                ColabWithStar.no,
                HitSongwriter.yes,
                Hit_targetClass.yes));

        addTuple(new DataTuple("I Love You",
                Intro.Over21Secs,
                No_Songwriters.two,
                ColabWithStar.no,
                HitSongwriter.no,
                Hit_targetClass.no));

        addTuple(new DataTuple("Bitter Sweet Symphony",
                Intro.Between10and21Secs,
                No_Songwriters.three,
                ColabWithStar.no,
                HitSongwriter.yes,
                Hit_targetClass.yes));

        addTuple(new DataTuple("The Drugs Don't Work",
                Intro.Over21Secs,
                No_Songwriters.one,
                ColabWithStar.no,
                HitSongwriter.no,
                Hit_targetClass.no));

        addTuple(new DataTuple("Tainted Love",
                Intro.Under11Secs,
                No_Songwriters.one,
                ColabWithStar.no,
                HitSongwriter.yes,
                Hit_targetClass.yes));

        addTuple(new DataTuple("Bedsitter",
                Intro.Between10and21Secs,
                No_Songwriters.two,
                ColabWithStar.no,
                HitSongwriter.no,
                Hit_targetClass.no));

        addTuple(new DataTuple("I Touch Myself",
                Intro.Under11Secs,
                No_Songwriters.fourOrMore,
                ColabWithStar.no,
                HitSongwriter.yes,
                Hit_targetClass.yes));

        addTuple(new DataTuple("Love School",
                Intro.Between10and21Secs,
                No_Songwriters.two,
                ColabWithStar.no,
                HitSongwriter.no,
                Hit_targetClass.no));

        addTuple(new DataTuple("Mickey",
                Intro.Under11Secs,
                No_Songwriters.two,
                ColabWithStar.no,
                HitSongwriter.yes,
                Hit_targetClass.yes));

        addTuple(new DataTuple("Nobody",
                Intro.Between10and21Secs,
                No_Songwriters.one,
                ColabWithStar.no,
                HitSongwriter.no,
                Hit_targetClass.no));
    }
}
