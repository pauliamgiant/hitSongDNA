package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AttributeRegistryTest {

    DataSet dataset;

    @BeforeMethod(groups = {"AllTests", "Classifier"})
    public void setUp() throws FileNotFoundException {
        dataset = null;
        AttributeRegistry.getInstance().updateAttributeDataFromARFF();
    }

    @AfterMethod(groups = {"AllTests", "Classifier"})
    public void tearDown() {
        dataset = null;
        AttributeRegistry.getInstance().flushRegistry();
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testValidAttributeValue() {
    String attributeName = "TEMPO" ,
            attrVal1 = "111-120",
            attrVal2 = ">130",
            attrVal3 = "110-121",
            attrVal4 = "<130";
    assertEquals(true,AttributeRegistry.getInstance().validAttributeValue(attributeName,attrVal1));
    assertEquals(true,AttributeRegistry.getInstance().validAttributeValue(attributeName,attrVal2));
    assertEquals(false,AttributeRegistry.getInstance().validAttributeValue(attributeName,attrVal3));
    assertEquals(false,AttributeRegistry.getInstance().validAttributeValue(attributeName,attrVal4));
    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testPrintAttributesAndVals(){
        System.out.println(AttributeRegistry.getInstance().printAttributesAndVals());
        assertEquals(AttributeRegistry.getInstance().printAttributesAndVals().length(),9997);

    }

    @Test(groups = {"AllTests", "Classifier"})
    public void testUpdateAttributeDataFromARFF() {
        Map<String, LinkedHashSet> testMap = AttributeRegistry.getInstance().getAttributesAndValues();
        assertEquals(testMap.size(),36);

    }

    @Test(groups = {"AllTests", "Classifier"})
    public void intro_LengthTest(){
        List<String> testMe = AttributeRegistry.getInstance().getValues("INTRO_LEN");
        assertEquals(testMe.size(),4);
    }
}