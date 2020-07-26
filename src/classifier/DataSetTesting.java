package classifier;

import java.io.FileNotFoundException;


public class DataSetTesting {


    public static void main(String[] args) throws FileNotFoundException {
        DataSet mySet = new DataSet();
        //System.out.println(mySet.printOutDataSet());
       // DataTuple newTuple = TupleBuilder.getUnclassifiedHitTuple();
        Classifier classifier = new NaiveBayes(mySet);
      // System.out.println("Your song is a HIT: " + classifier.songIsLikelyToBeAHit(newTuple));

    }
}
