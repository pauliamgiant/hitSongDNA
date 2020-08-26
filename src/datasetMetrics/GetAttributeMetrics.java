package datasetMetrics;

import classifier.DataSet;
import classifier.DataTuple;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetAttributeMetrics {


    public static List ListlistOfAttributeValuesInDataset(String attributeName) {
        return null;
    }

    public static Map<String, Long> getTotalsForAttributes(DataSet mySet, String attributeType) {
        List tuples = mySet.getTuples();
        List valuesOfAttr = new ArrayList<>();
        for (int i = 0; i < tuples.size(); i++) {
            DataTuple dt = (DataTuple) tuples.get(i);
//            System.out.println(dt.getAttribute("GENRE").getValue());
            valuesOfAttr.add(dt.getAttribute(attributeType).getValue());
        }
        // https://stackoverflow.com/questions/505928/how-to-count-the-number-of-occurrences-of-an-element-in-a-list
        Map<String, Long> counts = (Map<String, Long>) valuesOfAttr.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//        System.out.println(counts);

        return sortAttributeTotals(counts);
    }

    public static Map<String, Long> getTotalsForAttributesHIT(DataSet mySet, String attributeType) {
        List tuples = mySet.getTuples();
        List valuesOfAttr = new ArrayList<>();
        for (int i = 0; i < tuples.size(); i++) {
            DataTuple dt = (DataTuple) tuples.get(i);
            if (dt.getTargetClass().getValue().equals("HIT")) {
                valuesOfAttr.add(dt.getAttribute(attributeType).getValue());
            }
        }
        Map<String, Long> counts = (Map<String, Long>) valuesOfAttr.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//        System.out.println(counts);
        return counts;
    }

    // https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values
    public static Map<String, Long> sortAttributeTotals(Map<String, Long> unsortedMap) {
        List<Map.Entry<String, Long>> list = new ArrayList<>(unsortedMap.entrySet());
//        list.sort(Map.Entry.comparingByValue());
        list.sort(Map.Entry.comparingByValue());
        List<Map.Entry<String, Long>> reverse = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reverse.add(list.get(i));
        }
        Map<String, Long> result = new LinkedHashMap<>();
        for (Map.Entry<String, Long> entry : reverse) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static List getListOfTotals(DataSet mySet, String attributeType){
        List l = new ArrayList<>(getTotalsForAttributes(mySet,attributeType).values());
        return l;
    }

    public static Map<String, Double> getHitPercentagesOfAttributes(DataSet mySet, String attributeType) {
        Map<String, Double> percentages = new LinkedHashMap<>();
        Map<String, Long> sortedMap = getTotalsForAttributes(mySet, attributeType);
        Map<String, Long> hitTotals = getTotalsForAttributesHIT(mySet, attributeType);

        for (Map.Entry<String, Long> entry : sortedMap.entrySet()
        ) {
            Long val = entry.getValue();
            String key = entry.getKey();
            Long hitVal = hitTotals.get(key);
            if (hitVal != null) {
                float percent = (float) hitVal / val * 100;
                Double conv = (double) percent;
                percentages.put(key, conv);
            }
        }
        return percentages;
    }


}


