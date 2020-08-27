package classifier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class ImportARFFDataset {

    /**
     * Imports and formats data from an ARFF file.
     * This means formatting Attributes, Values and Tuples
     */

    private List<String> attributes;
    private Map<String, LinkedHashSet> attributeValues;
    private List<String[]> dataset;


    public ImportARFFDataset() throws FileNotFoundException {
        attributes = new ArrayList<String>();
        attributeValues = new LinkedHashMap<>();
        dataset = new ArrayList<String[]>();
        parseARFF();
    }

    private void parseARFF(){
        Scanner fileScanner = null;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("one_hit_wonder_preprocessed_FINAL.arff");
        InputStream in = null;
        try {
            in = resource.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileScanner = new Scanner(in);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            // ARFF files use '@attribute' to indicate attributes

            if (line.startsWith("@attribute")) {
                String attrName = line.substring(line.indexOf(' ') + 1, line.indexOf('{') - 1);
                attributes.add(attrName);
                attributeValues.put(attrName, getAttributeValues(line));
            }

            // this separates out the Tuple values, removes all unwanted characters and stores in list of tuple string[]

            if (!line.equals("") && (!line.startsWith("@"))) {
                String cleanString = line.replaceAll("['()+\\]^:\\\\]", "");
                String[] splitARFFValues = cleanString.split(",");
                dataset.add(splitARFFValues);
            }

        }
    }

    public List<String[]> getTuples() {
        return dataset;
    }

    public Map<String,LinkedHashSet> getAttrAndVals(){
        return attributeValues;
    }


    /**
     *
     * @param line
     * @return an ordered set of Attribute values
     */
    private LinkedHashSet<String> getAttributeValues(String line) {
        LinkedHashSet<String> setOFAttrVals;
        String selectedSubString = line.substring(line.indexOf('{'), line.indexOf('}'));
        String cleanString = selectedSubString.replaceAll("[{}'()+\\]^:\\\\]", "");
        String[] splitARFFValues = cleanString.split(",");
        setOFAttrVals = new LinkedHashSet<>(Arrays.asList(splitARFFValues));
        // System.out.println(setOFAttrVals);
        return setOFAttrVals;
    }
}
