package lyricAnalysis;

import java.util.*;

public class WordCountAnalysis {

    HashSet<String> hitWords;
    List<String> lyrics;

    public WordCountAnalysis(List<String> lyrics) {
        hitWords = new HashSet<>();
        for (HitWords word : HitWords.values()) {
            hitWords.add(word.toString());
        }
        this.lyrics = lyrics;
    }

    private Set<String> setOfDistinctWords() {
        Set<String> distinctWords = new HashSet<>();
        distinctWords.addAll(WordExtractor.listOfAllWords(lyrics));
        return distinctWords;
    }

    public int totalNumberOfWords() {
        // System.out.println(listOfAllWords());
        return WordExtractor.listOfAllWords(lyrics).size();
    }

    public int numberOfDistinctWords() {
       // System.out.println(setOfDistinctWords());
        return setOfDistinctWords().size();
    }

    public int totalNumberOfHitWords() {
        int count = 0;
        List<String> loaw = WordExtractor.listOfAllWords(lyrics);
        for (String word : loaw) {
            if (hitWords.contains(word.toUpperCase())) {
                count++;
            }
        }
        return count;
    }

    public int numberOfDistinctHitWordsUsed() {
        int count = 0;
        Set<String> distinctHitWords = new HashSet<>();
        Set<String> distinctWords = setOfDistinctWords();
        for (String word : distinctWords
        ) {
            if (hitWords.contains(word.toUpperCase())) {
                distinctHitWords.add(word);
            }
        }
        //System.out.println(distinctHitWords);
        return distinctHitWords.size();
    }


}
