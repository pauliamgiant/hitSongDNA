package lyricAnalysis;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LyricalComplexityAnalysis {

    List<String> lyrics;
    double numberOfWords;
    double numberOfSentences;
    double syllableCount;
    Set<Character> vowels;

    /**
     * Provides Flesch-Kincaid score for grade level
     * @param lyrics
     */
    public LyricalComplexityAnalysis(List<String> lyrics) {
        this.lyrics = lyrics;
        numberOfSentences = this.lyrics.size();
        numberOfWords = WordExtractor.listOfAllWords(this.lyrics).size();
        vowels = new HashSet<Character>(Arrays.asList('A','E','I','O','U','Y'));
        syllableCount = countSyllablesInWords();
    }


    public double getGradeLevel() {
        //Flesch-Kincaid ( 0.39 * ( float words.Length) / (float sentences.Length ) ) + ( 11.8 * (float syllableCount ) / ( float words.Length) ) - 15.59
      return (0.39 * (numberOfWords / numberOfSentences)) + (11.8 * (syllableCount / numberOfWords)) - 15.59;
    }

    /**
     * Required for Flesch-Kincaid equation
     * @return count int
     */
    private int countSyllablesInWords() {
        int count = 0;
        List<String> songWords = WordExtractor.listOfAllWords(lyrics);
        for(int i = 0 ; i < songWords.size();i++){
        count += countSyllables(songWords.get(i));
        }
        return count;
    }

    //https://stackoverflow.com/questions/34209176/counting-syllables-within-a-word

    /**
     * Required for Flesch-Kincaid equation
     * @return count syllables in int
     */

    private int countSyllables(String word) {
        int syllableCount = 0;
        int index = word.length() - 1;
        while (index >= 0 && word.charAt(index) == 'E') {
            index--;
        }
        boolean hasVowellBefore = false;
        while (index >= 0) {
            if (vowels.contains(word.charAt(index))) {
                if (!hasVowellBefore) {
                    syllableCount++;
                    hasVowellBefore = true;
                }
            } else {
                hasVowellBefore = false;
            }
            index--;
        }
        return syllableCount;
    }
}


