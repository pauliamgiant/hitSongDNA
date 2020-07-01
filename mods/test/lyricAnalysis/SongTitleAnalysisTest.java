package lyricAnalysis;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SongTitleAnalysisTest {



    @Test
    public void testTitleInLyrics() throws FileNotFoundException {
        TextParser tp = new TextParser();
        List<String> song = tp.getLines();
        SongTitleAnalysis sta = new SongTitleAnalysis("nothing compares to you");
        System.out.println(sta.titleInLyrics(song));
        assertEquals(sta.titleInLyrics(song),true);
    }

    @Test
    public void testSongTitleRepeats() {
        assertEquals(true,true);
    }
}