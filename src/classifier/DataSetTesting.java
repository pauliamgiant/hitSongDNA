package classifier;

import java.io.FileNotFoundException;
import java.util.Set;


public class DataSetTesting {


    public static void main(String[] args) throws FileNotFoundException {
        try {
            AttributeRegistry.getInstance().updateAttributeDataFromARFF();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataSet mySet = new DataSet();
        Set allAttr = AttributeRegistry.getInstance().getSetOfAttributes();
        for (Object attr: allAttr
             ) {
            System.out.println(attr);
        }

        System.out.println(mySet.printOutDataSet());

     //   System.out.println(GetAttributeMetrics.getHitPercentagesOfAttributes(mySet,"HIT_WRITER"));


        //System.out.println(mySet.printOutDataSet());
//       DataTuple newTuple = TupleBuilder.getUnclassifiedHitTuple();
//        Classifier classifier = new NaiveBayes(mySet);
//      System.out.println("Your song is a HIT: " + classifier.songIsLikelyToBeAHit(newTuple));

    }
}
