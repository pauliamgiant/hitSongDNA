package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;

public class NaiveBayesTest {

    private String tupleString1;
    private String tupleString2;

    @BeforeMethod(groups = {"AllTests", "Classifier"})
    public void setUp() throws FileNotFoundException {

        AttributeRegistry.getInstance().updateAttributeDataFromARFF();
        tupleString1 = "12-23,>130,pop,mf-duet,DMAJ,I-iii-IV-I,TRUE,DMAJ,I-iii-IV-I,3,FALSE,no,i-VI-III-VII,TRUE,vi-IV-I-V,4,5-6,1-5-3-5,1,3,triad-notes,4-6-1-1,4,3,mixed-harm,none,7-14,1.75-2.61,-inf-187,7-9,-inf-2,2-5,8-11,lover,no";
        tupleString2 =  "-inf-12,111-120,rock,male,Bm,iv-VII-i-VII,FALSE,DMAJ,ii-V-vi-V,3,FALSE,no,iv-VII-i-VII,FALSE,ii-V-vi-V,3,3-4,5-6-1-1,5,3,mixed-harm,7-3-3-6,7,3,mixed-harm,dancebeat,35-41,-0.85-0.01,372.5-405.5,14-18,7-8,26-37,23-31,innuendist,yes";

    }

    @AfterMethod(groups = {"AllTests", "Classifier"})
    public void tearDown() {
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testSongIsLikelyToBeAHit() throws FileNotFoundException {

        DataSet ds = new DataSet();
        String[] splitARFFValues1 = tupleString1.split(",");
        String[] splitARFFValues2 = tupleString2.split(",");
        DataTuple newTuple1 = new DataTuple(splitARFFValues1);
        DataTuple newTuple2 = new DataTuple(splitARFFValues2);
        Classifier classifier = new NaiveBayes(ds);
        boolean result1 = classifier.songIsLikelyToBeAHit(newTuple1);
        boolean result2 = classifier.songIsLikelyToBeAHit(newTuple2);

        assertEquals(result1, true);
        assertEquals(result2, false);
    }
}