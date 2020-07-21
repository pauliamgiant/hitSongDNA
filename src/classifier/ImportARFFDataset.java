package classifier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportARFFDataset {

    List<String> dataset;

    public ImportARFFDataset() {
        dataset = new ArrayList<String>();
    }


    public List<String> getTuples() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/org/openjfx/Resources/one_hit_wonder_preprocessed.arff"));
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            if(!line.equals("")&&(!line.startsWith("@"))) {
                dataset.add(line);
            }
        }

        return dataset;
    }
}
