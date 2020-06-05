package lyricAnalysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineRepetitionAnalysis {

    /**
     * Counts the number of full line repeats in a song.
     */

    public static int analyseRepetition(List<String> listToCheck) {
        HashMap<String, Integer> map = StringCounter.countStrings(listToCheck);
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            count += entry.getValue() - 1;
        }
        return count;
    }
}
