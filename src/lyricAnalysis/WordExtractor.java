package lyricAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordExtractor {

    /**
     *
     * @param lyrics
     * @return a list of unique words used in a song
     */
    public static List<String> listOfAllWords(List<String> lyrics) {
        List<String> allWords = new ArrayList<>();
        for (int i = 0; i < lyrics.size(); i++) {
            String line = lyrics.get(i).toUpperCase();
            String[] arr = line.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
            allWords.addAll(Arrays.asList(arr));
        }
        int i = 0;
        int size = allWords.size();
        for (; i < size; i++) {
            String word = allWords.get(i);
            if (word.matches("^\\s*$")) {
                allWords.remove(i);
                i--;
                size--;
            }
        }
        return allWords;
    }
}
