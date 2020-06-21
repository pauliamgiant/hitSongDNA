package classifier;

import classifier.Attributes.*;

public class DataSetTesting {

    public static void main(String[] args) {
        DataSet mySet = new DataSet();
        DataTuple newTuple = new DataTuple("Song14", Outlook.sunny, Temp.hot, Humidity.high, Windy.yes);
        System.out.println(mySet.printOutDataSet());
        Classifier classifier = new NaiveBayes(mySet);
        System.out.println("Your song is a HIT: "+classifier.songIsLikelyToBeAHit(newTuple));
    }
}
