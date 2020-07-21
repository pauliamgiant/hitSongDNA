package lyricAnalysis;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LyricalComplexityAnalysisTest {

    List<String> lyrics;
    List<String> testList;



    @Test(groups = {"AllTests", "LyricAnalysis"})
    public void testGetGradeLevel() {
        lyrics = MockDataSongNothingCompares.getTestSong();
        testList = new ArrayList<>();
        testList.add("This is a sentence");
        testList.add("And so is this");
        testList.add("Hallo you troublesome lad!!");
        testList.add("Love you Love girl!!");
        testList.add("Hallo Girl troublesome Baby!! 99");
        LyricalComplexityAnalysis lca = new LyricalComplexityAnalysis(lyrics);
        System.out.println(lca.getGradeLevel());
        LyricalComplexityAnalysis lca2 = new LyricalComplexityAnalysis(testList);
        System.out.println(lca2.getGradeLevel());

    }


}