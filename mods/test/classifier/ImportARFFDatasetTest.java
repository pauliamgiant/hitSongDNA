package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.*;

public class ImportARFFDatasetTest {

    ImportARFFDataset iaf = new ImportARFFDataset();

    public ImportARFFDatasetTest() throws FileNotFoundException {
    }

    @BeforeMethod
    public void setUp() {

    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testGetTuples() {
        assertEquals(iaf.getTuples().size(), 160.0);
    }
}
