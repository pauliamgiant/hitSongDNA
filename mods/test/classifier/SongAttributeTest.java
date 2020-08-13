package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.*;

public class SongAttributeTest {

    SongAttribute arrt1;
    SongAttribute arrt2;
    SongAttribute arrt3;
    SongAttribute arrt4;
    SongAttribute arrt5;

    @BeforeMethod(groups = {"AllTests", "Classifier"})
    public void setUp() throws FileNotFoundException {
        DataSet ds = new DataSet();
        arrt1 = new SongAttribute("TEMPO","95-110" );
        arrt3 = new SongAttribute("VS_CH_SAME_CHRDS","TRUE");
    }

    @AfterMethod(groups = {"AllTests", "Classifier"})
    public void tearDown() {
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testGetName() {
        try {
            arrt2 = new SongAttribute("TEMPO","95-111" );
        } catch (IllegalArgumentException e) {
            // e.printStackTrace();
            System.out.println("Correctly caught IllegalArgument for invalid tempo.");
            assertEquals(false,false);
        }
        assertEquals(arrt1.getName(),"TEMPO");
        assertEquals(arrt3.getName(),"VS_CH_SAME_CHRDS");
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testGetValue() {
        assertEquals(arrt1.getValue(),"95-110");
        assertEquals(arrt3.getValue(),"TRUE");
        assertEquals(arrt3.getValue().equals("TRUE"),true);
        assertEquals(arrt3.getValue().equals("FALSE"),false);

    }
}