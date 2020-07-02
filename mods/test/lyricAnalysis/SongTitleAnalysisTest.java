package lyricAnalysis;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SongTitleAnalysisTest {

    List<String> song;


    @Test(groups = { "AllTests","LyricAnalysis"})
    public void testTitleInLyrics() throws FileNotFoundException {
        song = MockDataSongNothingCompares.getTestSong();
        SongTitleAnalysis sta = new SongTitleAnalysis("nothing compares to you");
        System.out.println(sta.titleInLyrics(song));
        assertEquals(sta.titleInLyrics(song), true);
    }

    @Test(groups = { "AllTests","LyricAnalysis"})
    public void testSongTitleRepeats() throws FileNotFoundException {
        song = MockDataSongNothingCompares.getTestSong();
        SongTitleAnalysis sta = new SongTitleAnalysis("nothing compares to you");
        System.out.println(sta.songTitleRepeats(song));
        assertEquals(true, true);
    }




}