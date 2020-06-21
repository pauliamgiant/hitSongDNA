package classifier;

import classifier.Attributes.Humidity;
import classifier.Attributes.Outlook;
import classifier.Attributes.Temp;
import classifier.Attributes.Windy;
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
        DataTuple newTuple = new DataTuple("Song14", Outlook.sunny, Temp.hot, Humidity.high, Windy.yes);
        NaiveBayes classifier = new NaiveBayes(ds);
        boolean result = classifier.songIsLikelyToBeAHit(newTuple);
        assertEquals(true, result);
    }
}