package datasetMetrics;

import classifier.DataSet;
import classifier.DataTuple;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetAttributeMetrics {

    /**
     * Static class to provide totals on Attribute values in dataset
     */


    /**
     *
     * @param mySet
     * @param attributeType
     * @return A map of total number of occurences of each value of a given attribute in the dataset
     */
    public static Map<String, Long> getTotalsForAttributes(DataSet mySet, String attributeType) {
        List tuples = mySet.getTuples();
        List valuesOfAttr = new ArrayList<>();
        for (int i = 0; i < tuples.size(); i++) {
            DataTuple dt = (DataTuple) tuples.get(i);
            valuesOfAttr.add(dt.getAttribute(attributeType).getValue());
        }
        // https://stackoverflow.com/questions/505928/how-to-count-the-number-of-occurrences-of-an-element-in-a-list
        Map<String, Long> counts = (Map<String, Long>) valuesOfAttr.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return sortAttributeTotals(counts);
    }

    /**
     *
     * @param mySet
     * @param attributeType
     * @return A map of total number of occurences of each value of a given attribute in the dataset for a HIT only
     */
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
        return counts;
    }

    // https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values

    /**
     * Sorts the Totals of Attribute value counts by order of most featured first
     * @param unsortedMap
     * @return an ordered Map by value
     */
    public static Map<String, Long> sortAttributeTotals(Map<String, Long> unsortedMap) {
        List<Map.Entry<String, Long>> list = new ArrayList<>(unsortedMap.entrySet());
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

    /**
     *
     * @param mySet
     * @param attributeType
     * @return a list of the value totals of each attribute. Converts map essentially
     */
    public static List getListOfTotals(DataSet mySet, String attributeType) {
        List l = new ArrayList<>(getTotalsForAttributes(mySet, attributeType).values());
        return l;
    }

    /**
     *
     * @param mySet
     * @param attributeType
     * @return Calculates the percentage of this collection of values that contributed to a HIT
     */
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


