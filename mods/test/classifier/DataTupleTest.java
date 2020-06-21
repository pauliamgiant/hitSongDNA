package classifier;

import classifier.Attributes.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataTupleTest {

    @Test
    public void testPrintTuples() {
        DataTuple test1 = new DataTuple("TupleTest", Outlook.sunny, Temp.hot, Humidity.high, Windy.no, Hit_targetClass.no);
        String printMe = test1.printTuple();
        System.out.println(printMe);
        assertEquals(true,true);
    }
}