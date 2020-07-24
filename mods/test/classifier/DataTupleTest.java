package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertEquals;

public class DataTupleTest {

    DataTuple unClTupleToTestWith;
    DataTuple tupleToTestWith;

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        DataSet dataset = new DataSet();
        unClTupleToTestWith = TupleBuilder.getUnclassifiedHitTuple();
        tupleToTestWith = TupleBuilder.getClassifiedTuple();

    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testNumberOfAttributes() {
        assertEquals(unClTupleToTestWith.numberOfAttributes(), 29);
        assertEquals(tupleToTestWith.numberOfAttributes(), 30);
    }

    @Test
    public void testPrintTuple() {
        System.out.println(unClTupleToTestWith.printTuple());
        assertEquals(unClTupleToTestWith.printTuple().startsWith("INTRO_LEN=12-23, TEMPO=111-120"),true);
        assertEquals(unClTupleToTestWith.printTuple().length(),596);
    }

    @Test
    public void testGetTargetClass() {
        String targ = tupleToTestWith.getTargetClass().getValue();
        SongAttribute targ2 = unClTupleToTestWith.getTargetClass();
        assertEquals(targ, "HIT");
        assertEquals(targ2, null);
    }

    @Test
    public void testGetAttribute() {
        SongAttribute introL = tupleToTestWith.getAttribute("INTRO_LEN");
        SongAttribute tempo = tupleToTestWith.getAttribute("TEMPO");
        System.out.println(introL.getValue());
        System.out.println(tempo.getValue());
        assertEquals(introL.getValue(),"12-23");
        assertEquals(tempo.getValue(),"111-120");
    }

    @Test
    public void testGetAllAttributes() {
       // System.out.println(tupleToTestWith.getAllTupleAttributeValues());
        assertEquals(tupleToTestWith.getAllTupleAttributeValues().size(),30);
    }


}