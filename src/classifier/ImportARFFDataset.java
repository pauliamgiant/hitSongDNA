package classifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ImportARFFDataset {


    private List<String> attributes;
    private Map<String,Set> attributeValues;
    private List<String[]> dataset;



    public ImportARFFDataset() throws FileNotFoundException {
        attributes =  new ArrayList<String>();
        attributeValues = new LinkedHashMap<>();
        dataset = new ArrayList<String[]>();
        parseARFF();
        AttributeRegistry.getInstance().updateAttributeDataFromARFF(attributeValues);
    }

    public void parseARFF() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/org/openjfx/Resources/one_hit_wonder_preprocessed_reduced.arff"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if (line.startsWith("@attribute")){
                String attrName = line.substring(line.indexOf(' ')+1,line.indexOf('{')-1);
                //System.out.println(attrName);
                attributes.add(attrName);
                attributeValues.put(attrName,getAttributeValues(line));
            }

            if (!line.equals("") && (!line.startsWith("@"))) {
                String cleanString = line.replaceAll("['()+\\]^:\\\\]", "");
                String[] splitARFFValues = cleanString.split(",");
                dataset.add(splitARFFValues);
            }

        }
    }

    public List<String[]> getTuples(){
        return dataset;
    }


    public Set<String> getAttributeValues(String line){
                Set<String> setOFAttrVals;
                String selectedSubString = line.substring(line.indexOf('{'),line.indexOf('}'));
                String cleanString = selectedSubString.replaceAll("[{}'()+\\]^:\\\\]","");
                String[] splitARFFValues = cleanString.split(",");
                setOFAttrVals = new HashSet<>(Arrays.asList(splitARFFValues));
       // System.out.println(setOFAttrVals);
        return setOFAttrVals;
    }
}
