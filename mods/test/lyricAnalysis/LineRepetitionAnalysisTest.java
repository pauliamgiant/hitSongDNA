package lyricAnalysis;

import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class LineRepetitionAnalysisTest {

    List<String> song;

    @Test(groups = {"AllTests", "LyricAnalysis"})
    public void testAnalyseRepetition() {
        song = MockDataSongNothingCompares.getTestSong();
        int tally = LineRepetitionAnalysis.analyseRepetition(song);
        System.out.println(tally);
        assertEquals(8, tally);
    }
}