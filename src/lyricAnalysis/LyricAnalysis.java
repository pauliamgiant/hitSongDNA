package lyricAnalysis;

import java.io.FileNotFoundException;
import java.util.List;

public class LyricAnalysis {

    List<String> lyricsByLine;
    int numberOfLineRepeats;
    Archetypes archetype;
    int numberOfKeyTerms;
    int numberOfRhymes;
    int numberOfTimesWordsRepeated;

    public LyricAnalysis() {
        try {
            lyricsByLine = new TextParser().getLines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LineRepetitionAnalysis lra = new LineRepetitionAnalysis();
        numberOfLineRepeats = lra.analyseRepetition(lyricsByLine);
    }


}
