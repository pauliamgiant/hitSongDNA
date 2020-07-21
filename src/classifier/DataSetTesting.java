package classifier;

import java.io.FileNotFoundException;


public class DataSetTesting {



    public static void main(String[] args) throws FileNotFoundException {
        DataSet mySet = new DataSet();
        System.out.println(mySet.printOutDataSet());

      DataTuple newTuple = UnclassifiedTupleBuilder.getUnclassifiedTuple();

        Classifier classifier = new NaiveBayes(mySet);
       System.out.println("Your song is a HIT: " + classifier.songIsLikelyToBeAHit(newTuple));

//        ImportARFFDataset iad = new ImportARFFDataset();
//        List<String[]> importedDataset = iad.getTuples();
//        for (int i = 0; i < importedDataset.size(); i++) {
//            System.out.println(Arrays.toString(importedDataset.get(i)));
//        }

    }
}
