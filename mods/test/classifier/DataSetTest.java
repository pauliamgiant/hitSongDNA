package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataSetTest {

    DataSet dataset;

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        dataset = new DataSet();
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testDataSetSize() {
        assertEquals(dataset.dataSetSize(),166.0);
    }

    @Test
    public void testGetTuples() {
        List listOfTuples = dataset.getTuples();
        assertEquals(listOfTuples.size(),166);
    }

//    @Test
//    public void testAddTuple() {
//        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
//        assertEquals(dataset.dataSetSize(),167.0);
//        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
//        assertEquals(dataset.dataSetSize(),168.0);
//        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
//        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
//        assertEquals(dataset.dataSetSize(),170.0);
//    }

    @Test
    public void testPrintOutDataSet() {
        String printout = dataset.printOutDataSet();
        assertEquals(printout.length(),101914);

    }

}