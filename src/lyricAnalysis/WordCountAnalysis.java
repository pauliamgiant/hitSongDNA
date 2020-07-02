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


    private List<String> listOfAllWords() {
        List<String> allWords = new ArrayList<>();
        for (int i = 0; i < lyrics.size(); i++) {
            String line = lyrics.get(i).toUpperCase();
            //String[] arr = line.split("[^a-zA-Z]+");
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

    private Set<String> setOfDistinctWords() {
        Set<String> distinctWords = new HashSet<>();
        distinctWords.addAll(listOfAllWords());
        return distinctWords;
    }

    public int totalNumberOfWords() {
       // System.out.println(listOfAllWords());
        return listOfAllWords().size();
    }

    public int numberOfDistinctWords() {
        System.out.println(setOfDistinctWords());
        return setOfDistinctWords().size();
    }

    public int totalNumberOfHitWords() {
        int count = 0;
        List<String> loaw = listOfAllWords();
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
        System.out.println(distinctHitWords);
        return distinctHitWords.size();
    }


}
