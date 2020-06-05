package lyricAnalysis;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class StringCounterTest {

    @Test(groups = { "AllTests"})
    public void testCountStrings() {
        HashMap<String,Integer> results = new HashMap<>();
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Sentence1");
        testList.add("Sentence1");
        testList.add("Sentence1");
        testList.add("Sentence2");
        testList.add("Sentence2");
        testList.add("Sentence2");
        results = StringCounter.countStrings(testList);
        System.out.println(results);
        HashMap<String, Integer> finalResults = results;
        Optional<Integer> count = Optional.ofNullable(results.get("Sentence1")).map(m -> finalResults.get("Sentence1"));
        Optional<Integer> count2 = Optional.ofNullable(results.get("Sentence2")).map(m -> finalResults.get("Sentence2"));
        Optional<Integer> count3 = Optional.ofNullable(results.get("Sentence3")).map(m -> finalResults.get("Sentence3"));
        assertEquals(count,Optional.of(3));
        assertEquals(count,Optional.of(3));
        assertEquals(count,Optional.of(3));



    }
}