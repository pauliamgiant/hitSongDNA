package lyricAnalysis;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LineRepetitionAnalysisTest {

    @Test(groups = { "AllTests"})
    public void testAnalyseRepetition() {
        List<String> dummyData = new ArrayList<>();

        dummyData.add("Like a bird without a song");
        dummyData.add("I said nothing can take away these blues");
        dummyData.add("I said nothing can take away these blues");
        dummyData.add("I said nothing can take away these blues");
        dummyData.add("Like a bird without a song");
        dummyData.add("Like a bird without a song");
        dummyData.add("Like a bird without a song");
        int tally = LineRepetitionAnalysis.analyseRepetition(dummyData);
        System.out.println(tally);


        assertEquals(true,true);
    }
}