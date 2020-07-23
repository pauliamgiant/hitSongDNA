package classifier;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class AttributeRegistryTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void testUpdateAttributeDataFromARFF() throws FileNotFoundException {
        Map<String, Set> testMapEmpty = AttributeRegistry.getInstance().getAttributesAndValues();
        assertEquals(0,testMapEmpty.size());
        DataSet ds = new DataSet();
        testMapEmpty = AttributeRegistry.getInstance().getAttributesAndValues();
        assertEquals(30,testMapEmpty.size());
    }

    @Test
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

    @Test
    public void testPrintAttributesAndVals() throws FileNotFoundException {
        DataSet ds2 = new DataSet();


    }
}