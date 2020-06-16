package lyricAnalysis;

import java.io.FileNotFoundException;
import java.util.List;

public class LyricAnalysis {

    List<String> lyricsByLine;
    private int numberOfLineRepeats;
    private int numberOfNounRepeats;
    private int numberOfHitWords;
    private int numberOfRhymes;
    private int gradeLevelOfLyrics;
    private int repetitionOfTitle;
    private Archetypes archetype;
    //    int numberOfTimesWordsRepeated;

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


    public int getNumberOfLineRepeats() {
        return numberOfLineRepeats;
    }

    public int getNumberOfNounRepeats() {
        return numberOfNounRepeats;
    }

    public int getNumberOfHitWords() {
        return numberOfHitWords;
    }

    public int getNumberOfRhymes() {
        return numberOfRhymes;
    }

    public int getGradeLevelOfLyrics() {
        return gradeLevelOfLyrics;
    }

    public int getRepetitionOfTitle() {
        return repetitionOfTitle;
    }

    public Archetypes getArchetype() {
        return archetype;
    }
}
