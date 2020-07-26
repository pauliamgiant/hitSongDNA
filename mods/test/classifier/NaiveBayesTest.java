package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class NaiveBayesTest {

    private String tupleString1;
    private String tupleString2;

    @BeforeMethod
    public void setUp() {
        tupleString1 = "12-23,111-120,edm,mf-duet,AMAJ,FALSE,AMAJ,1,FALSE,yes,TRUE,4,4-5,1,2,triad-notes,1,4,roots,moneybeat,35-41,1.75-2.61,372.5-405.5,14-18,4-5,37-49,16-19,sage,yes";
        tupleString2 = "12-23,111-120,rock,male,GMAJ,TRUE,GMAJ,1,FALSE,yes,FALSE,2,11-inf,7,1,roots,1,4,roots,moneybeat,35-41,1.75-2.61,372.5-405.5,14-18,4-5,37-49,16-19,sage,yes";
    }

    @AfterMethod
    public void tearDown() {
    }

//    @Test(groups = { "AllTests"})
//    public void testSongIsLikelyToBeAHit() throws FileNotFoundException {
//        DataSet ds = new DataSet();
//        String[] splitARFFValues1 = tupleString1.split(",");
//        String[] splitARFFValues2 = tupleString2.split(",");
//        DataTuple newTuple1 = new DataTuple(splitARFFValues1);
//        DataTuple newTuple2 = new DataTuple(splitARFFValues2);
//        NaiveBayes classifier = new NaiveBayes(ds);
//        boolean result1 = classifier.songIsLikelyToBeAHit(newTuple1);
//        boolean result2 = classifier.songIsLikelyToBeAHit(newTuple2);
//
//        assertEquals(result1, true);
//        assertEquals(result2, false);
//    }
}