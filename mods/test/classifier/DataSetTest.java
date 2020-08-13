package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataSetTest {

    DataSet dataset;

    @BeforeMethod(groups = {"AllTests", "Classifier"})
    public void setUp() throws FileNotFoundException {
        AttributeRegistry.getInstance().updateAttributeDataFromARFF();
        dataset = new DataSet();


    }

    @AfterMethod(groups = {"AllTests", "Classifier"})
    public void tearDown() {
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testDataSetSize() {
        assertEquals(dataset.dataSetSize(),160.0);
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testGetTuples() {
        List listOfTuples = dataset.getTuples();
        assertEquals(listOfTuples.size(),160);
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testAddTuple() {
        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
        assertEquals(dataset.dataSetSize(),161.0);
        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
        assertEquals(dataset.dataSetSize(),162.0);
        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
        dataset.addTuple(TupleBuilder.getUnclassifiedHitTuple());
        assertEquals(dataset.dataSetSize(),164.0);
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testPrintOutDataSet() {
        String printout = dataset.printOutDataSet();
        assertEquals(printout.length(),120435);

    }

}