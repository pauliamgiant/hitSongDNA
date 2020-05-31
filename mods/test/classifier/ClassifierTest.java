package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClassifierTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(groups = { "AllTests"})
    public void testSongIsLikelyToBeAHit() {
        Classifier classifier = new Classifier();
        boolean result = classifier.songIsLikelyToBeAHit();
        assertEquals(true, result);
    }
}