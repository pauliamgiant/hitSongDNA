package lyricAnalysis;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestKeyTermAnalysis {

    @Test(groups = { "AllTests","LyricAnalysis"})
    public void testNumberOfKeyTerms() {


        ArrayList<String> testList = new ArrayList<>();
        testList.add("This is a sentence");
        testList.add("And so is ths");
        testList.add("Hallo you troublesome toad!!");
        testList.add("Love you Love toad!!");
        testList.add("Hallo Girl troublesome Baby!!");
        KeyTermAnalysis kta = new KeyTermAnalysis();
       int result =  kta.numberOfKeyTerms(testList);

        assertEquals(4,result);
    }
}