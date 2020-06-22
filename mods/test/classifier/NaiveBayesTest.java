package classifier;

import classifier.Attributes.ColabWithStar;
import classifier.Attributes.Intro;
import classifier.Attributes.No_Songwriters;
import classifier.Attributes.HitSongwriter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NaiveBayesTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(groups = { "AllTests"})
    public void testSongIsLikelyToBeAHit() {
        DataSet ds = new DataSet();
        DataTuple newTuple = new DataTuple("Song14", Intro.Under11Secs, No_Songwriters.one, ColabWithStar.yes, HitSongwriter.yes);
        NaiveBayes classifier = new NaiveBayes(ds);
        boolean result = classifier.songIsLikelyToBeAHit(newTuple);
        assertEquals(true, result);
    }
}