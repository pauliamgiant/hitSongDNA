package lyricAnalysis;

import java.io.FileNotFoundException;
import java.util.List;

public class LyricAnalysis {

    List<String> lyricsByLine;
    private final int numberOfLineRepeats;
    private final double gradeLevelOfLyrics;
    private final boolean songTitleInLyrics;
    private final int songTitleRepeats;
    private final int numberOfDistinctHitWords;
    private final int totalNumberOfHitWords;
    private final int numberOfDistinctWords;
    private final int totalNumberOfWords;


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
        System.out.println("numberOfLineRepeats: " + analysis.numberOfLineRepeats);
        System.out.println("gradeLevelOfLyrics: " + analysis.gradeLevelOfLyrics);
        System.out.println("totalNumberOfWords: " + analysis.totalNumberOfWords);
        System.out.println("songTitleRepeats: " + analysis.songTitleRepeats);
        System.out.println("numberOfDistinctHitWords: " + analysis.numberOfDistinctHitWords);
        System.out.println("totalNumberOfHitWords: " + analysis.totalNumberOfHitWords);
        System.out.println("String title repeats: " + analysis.getLineRepeatString());
    }

    public void showAllLyricData() {

        System.out.println("numberOfLineRepeats: " + numberOfLineRepeats);
        System.out.println("gradeLevelOfLyrics: " + gradeLevelOfLyrics);
        System.out.println("totalNumberOfWords: " + totalNumberOfWords);
        System.out.println("songTitleRepeats: " + songTitleRepeats);
        System.out.println("numberOfDistinctHitWords: " + numberOfDistinctHitWords);
        System.out.println("totalNumberOfHitWords: " + totalNumberOfHitWords);
        System.out.println("String title repeats: " + getLineRepeatString());
    }


    public int getNumberOfLineRepeats() {
        return numberOfLineRepeats;
    }

    public String getLineRepeatString() {
        if (numberOfLineRepeats < 7) {
            return "-inf-7";
        } else if (numberOfLineRepeats >= 7 && numberOfLineRepeats < 14) {
            return "7-14";
        } else if (numberOfLineRepeats >= 14 && numberOfLineRepeats < 21) {
            return "14-21";
        } else if (numberOfLineRepeats >= 21 && numberOfLineRepeats < 28) {
            return "21-28";
        } else if (numberOfLineRepeats >= 28 && numberOfLineRepeats < 35) {
            return "28-35";
        } else if (numberOfLineRepeats >= 35 && numberOfLineRepeats < 41) {
            return "35-41";
        } else if (numberOfLineRepeats >= 41 && numberOfLineRepeats < 51) {
            return "41-51";
        } else
            return "51-inf";
    }

    public double getGradeLevelOfLyrics() {
        return gradeLevelOfLyrics;
    }

    // LYR_GRADE_LVL {-inf--1.72,-1.72--0.85,-0.85-0.01,0.01-0.88,0.88-1.75,1.75-2.61,2.61-3.47,3.47-inf}
    public String getGradeLevelString() {
        if (gradeLevelOfLyrics < -1.72) {
            return "-inf--1.72";
        } else if (gradeLevelOfLyrics >= -1.72 && gradeLevelOfLyrics < -0.85) {
            return "-1.72--0.85";
        } else if (gradeLevelOfLyrics >= -0.85 && gradeLevelOfLyrics < 0.01) {
            return "-0.85-0.01";
        } else if (gradeLevelOfLyrics >= 0.01 && gradeLevelOfLyrics < 0.88) {
            return "0.01-0.88";
        } else if (gradeLevelOfLyrics >= 0.88 && gradeLevelOfLyrics < 1.75) {
            return "0.88-1.75";
        } else if (gradeLevelOfLyrics >= 1.75 && gradeLevelOfLyrics < 2.61) {
            return "1.75-2.61";
        } else if (gradeLevelOfLyrics >= 2.61 && gradeLevelOfLyrics < 3.47) {
            return "2.61-3.47";
        } else
            return "3.47-inf";
    }

    public int getTotalNumberOfWords() {
        return totalNumberOfWords;
    }

    // TOTAL_WORDS {-inf-187,187-212.5,212.5-249,249-286.5,286.5-328.5,328.5-372.5,372.5-405.5,405.5-inf}
    public String getTotalNumberOfWordsString() {
        if (totalNumberOfWords < 187) {
            return "-inf-187";
        } else if (numberOfLineRepeats >= 187 && numberOfLineRepeats < 212.5) {
            return "187-212.5";
        } else if (numberOfLineRepeats >= 212.5 && numberOfLineRepeats < 249) {
            return "212.5-249";
        } else if (numberOfLineRepeats >= 249 && numberOfLineRepeats < 286.5) {
            return "249-286.5";
        } else if (numberOfLineRepeats >= 286.5 && numberOfLineRepeats < 328.5) {
            return "286.5-328.5";
        } else if (numberOfLineRepeats >= 328.5 && numberOfLineRepeats < 372.5) {
            return "328.5-372.5";
        } else if (numberOfLineRepeats >= 372.5 && numberOfLineRepeats < 405.5) {
            return "372.5-405.5";
        } else
            return "405.5-inf";
    }


    public boolean isSongTitleInLyrics() {
        return songTitleInLyrics;
    }

    public int getSongTitleRepeats() {
        return songTitleRepeats;
    }

    //  TITLE_REPEATS {-inf-3,3-5,5-7,7-9,9-11,11-14,14-18,18-inf}

    public String getSongTitleRepeatString() {
        if (songTitleRepeats < 3) {
            return "-inf-3";
        } else if (songTitleRepeats >= 3 && songTitleRepeats < 5) {
            return "3-5";
        } else if (songTitleRepeats >= 5 && songTitleRepeats < 7) {
            return "5-7";
        } else if (songTitleRepeats >= 7 && songTitleRepeats < 9) {
            return "7-9";
        } else if (songTitleRepeats >= 9 && songTitleRepeats < 11) {
            return "9-11";
        } else if (songTitleRepeats >= 11 && songTitleRepeats < 14) {
            return "11-14";
        } else if (songTitleRepeats > 14 && songTitleRepeats <= 18) {
            return "14-18";
        } else
            return "18-inf";
    }

    // DISTINCT_HITWORDS {-inf-2,2-3,3-4,4-5,5-6,6-7,7-8,8-inf}


    public int getNumberOfDistinctHitWords() {
        return numberOfDistinctHitWords;
    }

    public String getNumberOfDistinctHitWordString() {
        if (numberOfDistinctHitWords < 2) {
            return "-inf-2";
        } else if (numberOfDistinctHitWords >= 2 && numberOfDistinctHitWords < 3) {
            return "2-3";
        } else if (numberOfDistinctHitWords >= 3 && numberOfDistinctHitWords < 4) {
            return "3-4";
        } else if (numberOfDistinctHitWords >= 4 && numberOfDistinctHitWords < 5) {
            return "4-5";
        } else if (numberOfDistinctHitWords >= 5 && numberOfDistinctHitWords < 6) {
            return "5-6";
        } else if (numberOfDistinctHitWords >= 6 && numberOfDistinctHitWords < 7) {
            return "6-7";
        } else if (numberOfDistinctHitWords >= 7 && numberOfDistinctHitWords < 8) {
            return "7-8";
        } else
            return "8-inf";
    }


    public int getTotalNumberOfHitWords() {
        return totalNumberOfHitWords;
    }

    // HITWORDS_TOTAL {-inf-2,2-5,5-7,7-9,9-10,10-11,11-13,13-17,17-20,20-22,22-26,26-37,37-49,49-inf}
    public String getTotalNumberOfHitWordsString() {
        if (totalNumberOfHitWords < 2) {
            return "-inf-2";
        } else if (totalNumberOfHitWords >= 2 && totalNumberOfHitWords < 5) {
            return "2-5";
        } else if (totalNumberOfHitWords >= 5 && totalNumberOfHitWords < 7) {
            return "5-7";
        } else if (totalNumberOfHitWords >= 7 && totalNumberOfHitWords < 9) {
            return "7-9";
        } else if (totalNumberOfHitWords >= 9 && totalNumberOfHitWords < 10) {
            return "9-10";
        } else if (totalNumberOfHitWords >= 10 && totalNumberOfHitWords < 11) {
            return "10-11";
        } else if (totalNumberOfHitWords > 11 && totalNumberOfHitWords <= 13) {
            return "11-13";
        } else if (totalNumberOfHitWords > 13 && totalNumberOfHitWords <= 17) {
            return "13-17";
        } else if (totalNumberOfHitWords > 17 && totalNumberOfHitWords <= 20) {
            return "17-20";
        } else if (totalNumberOfHitWords > 20 && totalNumberOfHitWords <= 22) {
            return "20-22";
        } else if (totalNumberOfHitWords > 22 && totalNumberOfHitWords <= 26) {
            return "22-26";
        } else if (totalNumberOfHitWords > 26 && totalNumberOfHitWords <= 37) {
            return "26-37";
        } else if (totalNumberOfHitWords > 37 && totalNumberOfHitWords <= 49) {
            return "37-49";
        } else
            return "49-inf";
    }

}







