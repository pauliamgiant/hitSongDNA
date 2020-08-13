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
        AttributeRegistry.getInstance().updateAttributeDataFromARFF();
        DataSet dataset = new DataSet();
        unClTupleToTestWith = TupleBuilder.getUnclassifiedHitTuple();
        tupleToTestWith = TupleBuilder.getClassifiedTuple();

    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testNumberOfAttributes() {
        assertEquals(unClTupleToTestWith.numberOfAttributes(), 35);
       assertEquals(tupleToTestWith.numberOfAttributes(), 36);
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testPrintTuple() {
        System.out.println(unClTupleToTestWith.printTuple());
        assertEquals(unClTupleToTestWith.printTuple().startsWith("INTRO_LEN=12-23, TEMPO=111-120"),true);
        assertEquals(unClTupleToTestWith.printTuple().length(),737);
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testGetTargetClass() {
        String targ = tupleToTestWith.getTargetClass().getValue();
        SongAttribute targ2 = unClTupleToTestWith.getTargetClass();
        assertEquals(targ, "HIT");
        assertEquals(targ2, null);
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testGetAttribute() {
        SongAttribute introL = tupleToTestWith.getAttribute("INTRO_LEN");
        SongAttribute tempo = tupleToTestWith.getAttribute("TEMPO");
        System.out.println(introL.getValue());
        System.out.println(tempo.getValue());
        assertEquals(introL.getValue(),"12-23");
        assertEquals(tempo.getValue(),"111-120");
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testGetAllAttributes() {
       // System.out.println(tupleToTestWith.getAllTupleAttributeValues());
        assertEquals(tupleToTestWith.getAllTupleAttributeValues().size(),36);
    }


}