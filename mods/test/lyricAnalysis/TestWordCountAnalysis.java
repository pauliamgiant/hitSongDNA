package lyricAnalysis;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestWordCountAnalysis {

    List<String> testList;
    List<String> nothingCompares;
    WordCountAnalysis wca;

    @BeforeMethod
    public void setUp() {
        testList = new ArrayList<>();
        testList.add("This is a sentence");
        testList.add("And so is this");
        testList.add("Hallo you troublesome toad!!");
        testList.add("Love you Love toad!!");
        testList.add("Hallo Girl troublesome Baby!! 99");

        nothingCompares = MockDataSongNothingCompares.getTestSong();
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testTotalNumberOfWords() {
        wca = new WordCountAnalysis(testList);
        assertEquals(wca.totalNumberOfWords(), 21);
        wca = new WordCountAnalysis(nothingCompares);
        // System.out.println(wca.totalNumberOfWords());
        assertEquals(wca.totalNumberOfWords(), 210);
    }

    @Test
    public void testNumberOfDistinctWords() {
        WordCountAnalysis wca = new WordCountAnalysis(testList);
        // System.out.println(wca.numberOfDistinctWords());
        assertEquals(wca.numberOfDistinctWords(), 14);
        wca = new WordCountAnalysis(nothingCompares);
        // System.out.println(wca.numberOfDistinctWords());
        assertEquals(wca.numberOfDistinctWords(), 107);
    }

    @Test
    public void testTotalNumberOfHitWords() {
        WordCountAnalysis wca = new WordCountAnalysis(testList);
        // System.out.println(wca.totalNumberOfHitWords());
        assertEquals(wca.totalNumberOfHitWords(), 4);
        wca = new WordCountAnalysis(nothingCompares);
        //System.out.println(wca.totalNumberOfHitWords());
        assertEquals(wca.totalNumberOfHitWords(), 7);
    }

    @Test
    public void testNumberOfDistinctHitWordsUsed() {
        WordCountAnalysis wca = new WordCountAnalysis(testList);
        //System.out.println(wca.numberOfDistinctHitWordsUsed());
        assertEquals(wca.numberOfDistinctHitWordsUsed(), 3);
        wca = new WordCountAnalysis(nothingCompares);
        assertEquals(wca.numberOfDistinctHitWordsUsed(), 5);
    }
}