package lyricAnalysis;

import java.util.HashMap;
import java.util.List;

public class StringCounter {

    public static HashMap<String, Integer> countStrings(List<String> list) {
        HashMap<String, Integer> totals = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (totals.containsKey(list.get(i).toLowerCase())) {
                totals.put(list.get(i).toLowerCase(), totals.get(list.get(i).toLowerCase()) + 1);
            }
            else{
                totals.put(list.get(i).toLowerCase(),1);
            }
        }
        return totals;
    }
}
