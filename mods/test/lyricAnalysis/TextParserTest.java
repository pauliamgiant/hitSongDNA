package lyricAnalysis;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TextParserTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

//    @Test(groups = { "AllTests","LyricAnalysis"})
//    public void testGetLines() throws FileNotFoundException {
//        TextParser parser = new TextParser();
//        List<String> lines = parser.getLines();
//        assertEquals(lines.size(),33 );
//        String check = lines.get(0);
//        assertEquals(true,check.endsWith("days"));
//    }
}