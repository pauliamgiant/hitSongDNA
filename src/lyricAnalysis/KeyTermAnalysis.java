package lyricAnalysis;

import java.util.HashSet;
import java.util.List;

public class KeyTermAnalysis {

    HashSet<String> keyTerms;

    public KeyTermAnalysis() {
        keyTerms = new HashSet<>();
        for (HitWords word: HitWords.values()){
             keyTerms.add(word.toString());
        }
    }

    public int numberOfKeyTerms(List<String> lyrics){
        int count = 0;

        for (int i = 0; i < lyrics.size(); i++) {
            String line = lyrics.get(i);
            String[] arr = line.split("[^a-zA-Z]+");
            for(int j = 0; j < arr.length; j ++)
            {
                System.out.println(arr[j]);
                if(keyTerms.contains(arr[j].toUpperCase())){
                    count ++;
                }
            }

        }
        return count;
    }
}
