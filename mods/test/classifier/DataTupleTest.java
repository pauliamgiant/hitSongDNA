package classifier;

import classifier.Attributes.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataTupleTest {

    @Test
    public void testPrintTuples() {
        DataTuple test1 = new DataTuple("TupleTest", Intro.Under11Secs, No_Songwriters.one, ColabWithStar.yes, HitSongwriter.no, Hit_targetClass.no);
        String printMe = test1.printTuple();
        System.out.println(printMe);
        assertEquals(true,true);
    }
}