package lyricAnalysis;

import java.io.FileNotFoundException;
import java.util.List;

public class LyricAnalysis {

    List<String> lyricsByLine;
    int numberOfLineRepeats;
    int numberOfKeyTerms;
    int numberOfRhymes;
    int numberOfTimesWordsRepeated;
    Archetypes archetype;

    public LyricAnalysis() {
        try {
            lyricsByLine = new TextParser().getLines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LineRepetitionAnalysis lra = new LineRepetitionAnalysis();
        numberOfLineRepeats = lra.analyseRepetition(lyricsByLine);

        //numberOfKeyTerms =

    }


}
