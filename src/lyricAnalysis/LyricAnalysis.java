package lyricAnalysis;

import java.io.FileNotFoundException;
import java.util.List;

public class LyricAnalysis {

    List<String> lyricsByLine;
    private int numberOfLineRepeats;
    private double gradeLevelOfLyrics;
    private boolean songTitleInLyrics;
    private int songTitleRepeats;
    private int numberOfDistinctHitWords;
    private int totalNumberOfHitWords;
    private int numberOfDistinctWords;
    private int totalNumberOfWords;

    //private int numberOfRhymes;

    private int repetitionOfTitle;

    //    int numberOfTimesWordsRepeated;

    public LyricAnalysis(String songTitle) {
        try {
            lyricsByLine = new TextParser().getLines();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LineRepetitionAnalysis lra = new LineRepetitionAnalysis();
        numberOfLineRepeats = lra.analyseRepetition(lyricsByLine);
        LyricalComplexityAnalysis lca = new LyricalComplexityAnalysis(lyricsByLine);
        gradeLevelOfLyrics = lca.getGradeLevel();
        SongTitleAnalysis sta = new SongTitleAnalysis(songTitle);
        songTitleInLyrics = sta.titleInLyrics(lyricsByLine);
        songTitleRepeats = sta.songTitleRepeats(lyricsByLine);
        WordCountAnalysis wca = new WordCountAnalysis(lyricsByLine);
        numberOfDistinctHitWords = wca.numberOfDistinctHitWordsUsed();
        totalNumberOfHitWords = wca.totalNumberOfHitWords();
        numberOfDistinctWords = wca.numberOfDistinctWords();
        totalNumberOfWords = wca.totalNumberOfWords();
    }

    public static void main(String[] args) {
        LyricAnalysis analysis = new LyricAnalysis("power of love");
        System.out.println("numberOfLineRepeats: "+analysis.numberOfLineRepeats);
        System.out.println("gradeLevelOfLyrics: "+analysis.gradeLevelOfLyrics);
        System.out.println("totalNumberOfWords: "+analysis.totalNumberOfWords);
        System.out.println("numberOfDistinctWords: "+analysis.numberOfDistinctWords);
        System.out.println("songTitleInLyrics: "+analysis.songTitleInLyrics);
        System.out.println("songTitleRepeats: "+analysis.songTitleRepeats);
        System.out.println("numberOfDistinctHitWords: "+analysis.numberOfDistinctHitWords);
        System.out.println("totalNumberOfHitWords: "+analysis.totalNumberOfHitWords);
    }


    public int getNumberOfLineRepeats() {
        return numberOfLineRepeats;
    }

    public double getGradeLevelOfLyrics() {
        return gradeLevelOfLyrics;
    }

    public boolean isSongTitleInLyrics() {
        return songTitleInLyrics;
    }

    public int getSongTitleRepeats() {
        return songTitleRepeats;
    }

    public int getNumberOfDistinctHitWords() {
        return numberOfDistinctHitWords;
    }

    public int getTotalNumberOfHitWords() {
        return totalNumberOfHitWords;
    }

    public int getNumberOfDistinctWords() {
        return numberOfDistinctWords;
    }

    public int getTotalNumberOfWords() {
        return totalNumberOfWords;
    }

    public int getRepetitionOfTitle() {
        return repetitionOfTitle;
    }
}
